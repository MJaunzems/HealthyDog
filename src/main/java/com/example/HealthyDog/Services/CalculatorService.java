package com.example.HealthyDog.Services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static final double RER_CONSTANT = 70.0;
    private static final double K_MINIMAL_ACTIVE = 1.2;
    private static final double K_LOW_ACTIVE = 1.4;
    private static final double K_MEDIUM_ACTIVE = 1.6;
    private static final double K_HIGH_ACTIVE = 1.8;
    private static final double K_VERY_HIGH_ACTIVE = 2.0;

    public double calculateRER(double weight) {
        return RER_CONSTANT * Math.pow(weight, 0.75);
    }

    public double calculateDailyCalories(double rer, double k) {
        return rer * k;
    }

    public double calculateDryFoodGrams(double dailyCalories, double dryFoodCalorieContent) {
        return dailyCalories / dryFoodCalorieContent;
    }

    public double calculateCannedFoodGrams(double dailyCalories, double cannedFoodCalorieContent) {
        return dailyCalories / cannedFoodCalorieContent;
    }

    public double validateAndSetK(String activityLevel) {
        switch (activityLevel) {
            case "minimal_active":
                return K_MINIMAL_ACTIVE;
            case "low_active":
                return K_LOW_ACTIVE;
            case "medium_active":
                return K_MEDIUM_ACTIVE;
            case "high_active":
                return K_HIGH_ACTIVE;
            case "very_high_active":
                return K_VERY_HIGH_ACTIVE;
            default:
                throw new IllegalArgumentException("Invalid activity level");
        }
    }
}
