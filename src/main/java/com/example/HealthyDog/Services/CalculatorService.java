package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Entities.FoodIngredientsEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {

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

    public List<FoodEntity> filterFoods(List<FoodEntity> allFoods, HttpSession session) {
        List<String> allergies = (List<String>) session.getAttribute("allergies");
        List<FoodEntity> filteredFoods = new ArrayList<>();
        for (FoodEntity food : allFoods) {
            boolean matchesType = session.getAttribute("type").equals(food.getPetType());
            boolean matchesAge = session.getAttribute("age").equals(food.getAgeType());
            boolean hasAllergy = false;

            List<FoodIngredientsEntity> ingredients = dryFoodService.getAllIngredientsById(food.getId());
            List<String> ingredientNames = ingredients.stream()
                    .map(FoodIngredientsEntity::getIngredientName).toList();

            for (String allergie : allergies) {
                if (ingredientNames.contains(allergie)) {
                    hasAllergy = true;
                    break;
                }
            }
            if (matchesAge && matchesType && !hasAllergy) {
                filteredFoods.add(food);
            }
        }
        return filteredFoods;
        /*Predicate<FoodEntity> filterPredicate = food -> {
            boolean matchesType = session.getAttribute("type").equals(food.getPetType());
            boolean matchesAge = session.getAttribute("age").equals(food.getAgeType());
            for (String allergie : session.getAttribute("allergies")){
                System.out.println("");
            }
            return false;
        };
        List<FoodEntity> filteredFoods = allFoods.stream()
                .filter(filterPredicate)
                .collect(Collectors.toList());
        System.out.println(allFoods);
        System.out.println(filteredFoods);
        return filteredFoods;*/
    }

    public double calculateFoodGrams(double dailyCalories, double foodCalorieContent) {
        return (dailyCalories / foodCalorieContent) * 100;
    }
}
