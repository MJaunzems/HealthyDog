package com.example.HealthyDog.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CannedFoodEntity {

    @Id
    @Column(name = "canned_id")
    private long cannedId;
    @Column(name = "canned_company")
    private String cannedCompany;
    @Column(name = "canned_food_age_type")
    private String cannedFoodAgeType;
    @Column(name = "canned_price")
    private double cannedPrice;
    @Column(name = "canned_weight")
    private double cannedWeight;
    @Column(name = "canned_calorie")
    private double cannedCalorie;
    @Column(name = "canned_food_pet_type")
    private String cannedFoodPetType;
    @Column(name = "image_name")
    private String cannedImageName;

    public CannedFoodEntity(long cannedId, String cannedCompany, String cannedFoodAgeType, double cannedPrice, double cannedWeight,  double cannedCalorie, String cannedFoodPetType, String cannedImageName) {
        this.cannedId = cannedId;
        this.cannedCompany = cannedCompany;
        this.cannedFoodAgeType = cannedFoodAgeType;
        this.cannedPrice = cannedPrice;
        this.cannedWeight = cannedWeight;
        this.cannedCalorie = cannedCalorie;
        this.cannedFoodPetType = cannedFoodPetType;
        this.cannedImageName = cannedImageName;
    }

}
