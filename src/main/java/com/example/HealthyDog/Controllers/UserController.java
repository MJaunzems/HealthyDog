package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.UserEntity;
import com.example.HealthyDog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Lazy
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = userService.loadUserByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
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

}
