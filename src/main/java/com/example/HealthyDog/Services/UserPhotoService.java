package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.UserPhotoEntity;
import com.example.HealthyDog.Repositories.UserPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserPhotoService {

    @Autowired
    private UserPhotoRepository userPhotoRepository;

    public void saveUserPhoto(MultipartFile file) throws IOException {
        UserPhotoEntity userPhoto = new UserPhotoEntity();
        userPhoto.setFileName(file.getOriginalFilename());
        userPhoto.setData(file.getBytes());
        userPhotoRepository.save(userPhoto);
    }

}

