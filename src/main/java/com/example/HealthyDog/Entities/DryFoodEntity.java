package com.example.HealthyDog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class DryFoodEntity {

    @Id
    private long dryId;
    private String dryCompany;
    private double dryPrice;
    private double dryWeight;
    private String dryFoodPetType;

    public DryFoodEntity(long dryId, String dryCompany, double dryPrice, double dryWeight, String dryFoodPetType) {
        this.dryId = dryId;
        this.dryCompany = dryCompany;
        this.dryPrice = dryPrice;
        this.dryWeight = dryWeight;
        this.dryFoodPetType = dryFoodPetType;
    }
}
