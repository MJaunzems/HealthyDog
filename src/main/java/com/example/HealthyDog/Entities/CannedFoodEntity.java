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
}
