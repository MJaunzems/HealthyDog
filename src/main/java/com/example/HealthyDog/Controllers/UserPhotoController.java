package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Services.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserPhotoController {

    @Autowired
    private UserPhotoService userPhotoService;

    @PostMapping("/upload")
    public String uploadUserPhoto(@RequestParam("file") MultipartFile file) {
        try {
            userPhotoService.saveUserPhoto(file);
            return "User photo uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading user photo: " + e.getMessage();
        }
    }

}

