package com.example.HealthyDog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "dry_food_entity")
public class DryFoodEntity {

    @Id
    @Column(name="dry_id")
    private long dryId;
    @Column(name="dry_company")
    private String dryCompany;
    @Column(name="dry_food_age_type")
    private String dryFoodAgeType;
    @Column(name="dry_price")
    private double dryPrice;
    @Column(name="dry_weight")
    private double dryWeight;
    @Column(name="dry_food_pet_type")
    private String dryFoodPetType;

    public DryFoodEntity(long dryId, String dryCompany, String dryFoodAgeType, double dryPrice, double dryWeight, String dryFoodPetType) {
        this.dryId = dryId;
        this.dryCompany = dryCompany;
        this.dryFoodAgeType = dryFoodPetType;
        this.dryPrice = dryPrice;
        this.dryWeight = dryWeight;
        this.dryFoodPetType = dryFoodPetType;
    }
}
