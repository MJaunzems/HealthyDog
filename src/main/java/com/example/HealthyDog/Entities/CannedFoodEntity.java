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
    @Column(name = "canned_price")
    private double cannedPrice;
    @Column(name = "canned_weight")
    private double cannedWeight;
    @Column(name = "canned_food_pet_type")
    private String cannedFoodPetType;

    public CannedFoodEntity(long cannedId, String cannedCompany, double cannedPrice, double cannedWeight, String cannedFoodPetType) {
        this.cannedId = cannedId;
        this.cannedCompany = cannedCompany;
        this.cannedPrice = cannedPrice;
        this.cannedWeight = cannedWeight;
        this.cannedFoodPetType = cannedFoodPetType;
    }
}
