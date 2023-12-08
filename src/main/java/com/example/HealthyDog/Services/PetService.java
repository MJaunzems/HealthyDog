package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.PetEntity;
import com.example.HealthyDog.Entities.UserEntity;
import com.example.HealthyDog.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public void savePet(Long userId, String petType, String petName, String petActivity, double petWeight, String petAge, String petIllness) {
        PetEntity pet = new PetEntity();
        pet.setUserId(userId);
        pet.setPetType(petType);
        pet.setPetName(petName);
        pet.setPetActivity(petActivity);
        pet.setPetWeight(petWeight);
        pet.setPetAge(petAge);
        pet.setPetIllness(petIllness);

        petRepository.save(pet);
    }

    public List<PetEntity> getPetsByUserId(long userId){
        return petRepository.findByUserId(userId);
    }
}
