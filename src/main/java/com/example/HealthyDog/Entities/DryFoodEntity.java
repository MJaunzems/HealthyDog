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
    private long dry_id;
    private String dry_company;
    private double dry_price;
    private double dry_weight;

    public DryFoodEntity(long dry_id, String dry_company, double dry_price, double dry_weight) {
        this.dry_id = dry_id;
        this.dry_company = dry_company;
        this.dry_price = dry_price;
        this.dry_weight = dry_weight;
    }
}
