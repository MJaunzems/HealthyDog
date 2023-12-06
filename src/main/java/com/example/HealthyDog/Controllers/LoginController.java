package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.UserEntity;
import com.example.HealthyDog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    public String user(){
        return "hello";
    }

    /*@GetMapping("/admin")
    public String admin(){
        List<UserEntity> users = userRepository.findAll();
        for(UserEntity user: users){
            String hashedPassword = passwordEncoder.encode(user.getUserPassword());
            user.setUserPassword(hashedPassword);
        }
        userRepository.saveAll(users);
        return "photoTest";
    }*/

}
