package com.example.HealthyDog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private String companyName;
    private double grams;
    private double daily;
    private String ageType;

}
