package com.example.HealthyDog.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class CannedFoodEntity {

    @Id
    private long cannedId;
    private String cannedCompany;
    private double cannedPrice;
    private double cannedWeight;
    private String cannedFoodPetType;

    public CannedFoodEntity(long cannedId, String cannedCompany, double cannedPrice, double cannedWeight, String cannedFoodPetType) {
        this.cannedId = cannedId;
        this.cannedCompany = cannedCompany;
        this.cannedPrice = cannedPrice;
        this.cannedWeight = cannedWeight;
        this.cannedFoodPetType = cannedFoodPetType;
    }
}
