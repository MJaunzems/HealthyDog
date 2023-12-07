package com.example.HealthyDog.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PET_ID")
    private long petId;
    @Column(name="user_id")
    private long userId;
    @Column(name="pet_type")
    private String petType;
    @Column(name="pet_name")
    private String petName;
    @Column(name="pet_activity")
    private String petActivity;
    @Column(name="pet_weight")
    private double petWeight;
    @Column(name="pet_age")
    private int petAge;
    @Column(name="pet_illness")
    private String petIllness;
    @Column(name="pet_price_range")
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
