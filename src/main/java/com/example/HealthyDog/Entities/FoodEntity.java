package com.example.HealthyDog.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity {

    private String name;
    private double weight;
    private int dailyPortion;
    private String imageName;

}
