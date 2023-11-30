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
    private long canned_id;
    private String canned_company;
    private double canned_price;
    private double canned_weight;
    private String dry_food_pet_type;

    public CannedFoodEntity(long canned_id, String canned_company, double canned_price, double canned_weight, String canned_food_pet_type) {
        this.canned_id = canned_id;
        this.canned_company = canned_company;
        this.canned_price = canned_price;
        this.canned_weight = canned_weight;
        this.dry_food_pet_type = canned_food_pet_type;
    }
}
