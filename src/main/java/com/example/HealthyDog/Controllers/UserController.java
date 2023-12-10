package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.PetEntity;
import com.example.HealthyDog.Entities.UserEntity;
import com.example.HealthyDog.MyUserDetails;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.PetService;
import com.example.HealthyDog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PetService petService;

    @Autowired
    AllergicFoodsRepository allergicFoodsRepository;

    @GetMapping("/profile")
    public String showProfile(Model model){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = userService.loadUserByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);
        List<PetEntity> pets = petService.getPetsByUserId(userDetails.getId());
        model.addAttribute("pets", pets);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam String username,@RequestParam int phone,@RequestParam String email){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.updateUser(userDetails, username, phone, email);
        return "redirect:/profile";
    }

    @PostMapping("/profile/change-password")
    public String changePassword(@RequestParam String currentPassword, @RequestParam String newPassword) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.changePassword(userDetails.getUsername(), currentPassword, newPassword);
        return "redirect:/profile";
    }

    @PostMapping("profile/savePet")
    public String savePet(@RequestParam String petType,
                          @RequestParam String petName,
                          @RequestParam String activity,
                          @RequestParam Double weight,
                          @RequestParam String age,
                          @RequestParam (required = false) String allergies,
                          RedirectAttributes redirectAttributes){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        petService.savePet(userDetails.getId(), petType, petName, activity, weight, age, allergies);
        redirectAttributes.addFlashAttribute("message", "Pet successfully added.");
        return "redirect:/profile";
    }
}
