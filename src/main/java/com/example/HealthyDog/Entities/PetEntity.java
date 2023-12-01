package com.example.HealthyDog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class PetEntity {

    @Id
    private long petId;
    private long userId;
    private String petType;
    private String petName;
    private String petActivity;
    private double petWeight;
    private int petAge;
    private String petIllness;
    private int petPriceRange;

    public PetEntity(long petId, long userId, String petType, String petName, String petActivity, double petWeight, int petAge, String petIllness, int petPriceRange) {
        this.petId = petId;
        this.userId = userId;
        this.petType = petType;
        this.petName = petName;
        this.petActivity = petActivity;
        this.petWeight = petWeight;
        this.petAge = petAge;
        this.petIllness = petIllness;
        this.petPriceRange = petPriceRange;
    }

}
