package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.UserEntity;
import com.example.HealthyDog.Services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@RequestParam String username,
                                               @RequestParam String email,
                                               @RequestParam int userPhone,
                                               @RequestParam String password) {
        userService.registerUser(username, email, userPhone, password);
        return "login";
    }

}
