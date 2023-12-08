package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Entities.FoodIngredientsEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CalculatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);


    private static final double RER_CONSTANT = 70.0;
    private static final double K_MINIMAL_ACTIVE = 1.2;
    private static final double K_LOW_ACTIVE = 1.4;
    private static final double K_MEDIUM_ACTIVE = 1.6;
    private static final double K_HIGH_ACTIVE = 1.8;
    private static final double K_VERY_HIGH_ACTIVE = 2.0;
    @Autowired
    DryFoodService dryFoodService;

    public double calculateRER(double weight) {
        return RER_CONSTANT * Math.pow(weight, 0.75);
    }

    public double calculateDailyCalories(double rer, double k) {
        return rer * k;
    }

    public double validateAndSetK(String activityLevel) {
        try {
        switch (activityLevel) {
            case "Minimal activity":
                return K_MINIMAL_ACTIVE;
            case "Low activity":
                return K_LOW_ACTIVE;
            case "Medium activity":
                return K_MEDIUM_ACTIVE;
            case "High activity":
                return K_HIGH_ACTIVE;
            case "Very high activity":
                return K_VERY_HIGH_ACTIVE;
            default:
                throw new IllegalArgumentException("Invalid activity level");
        }
        } catch (IllegalArgumentException e) {
            LOGGER.error("Unexceptionable activity level: {}", activityLevel);
            throw e;
        }
    }

    public List<FoodEntity> filterFoods(List<FoodEntity> allFoods, HttpSession session) {
        try {
        List<FoodEntity> filteredFoods = new ArrayList<>();
        List<String> allergies = (List<String>) session.getAttribute("allergies");
        boolean noAllergies = (allergies == null || allergies.isEmpty());

        for (FoodEntity food : allFoods) {
            boolean matchesType = session.getAttribute("type").equals(food.getPetType());
            boolean matchesAge = session.getAttribute("age").equals(food.getAgeType());
            boolean hasAllergy = false;
            if (!noAllergies) {
                List<FoodIngredientsEntity> ingredients = dryFoodService.getAllIngredientsById(food.getId());
                List<String> ingredientNames = ingredients.stream()
                        .map(FoodIngredientsEntity::getIngredientName).toList();
                for (String allergie : allergies) {
                    if (ingredientNames.contains(allergie)) {
                        hasAllergy = true;
                        break;
                    }
                }
            }
            if (matchesAge && matchesType && !hasAllergy) {
                filteredFoods.add(food);
            }
        }
        return filteredFoods;
        } catch (Exception e) {
            LOGGER.error("Error occurred during product filtration", e);
            throw new RuntimeException("Error occurred during product filtration", e);
        }
    }

    public double calculateFoodGrams(double dailyCalories, double foodCalorieContent) {
        return (dailyCalories / foodCalorieContent) * 100;
    }
}
