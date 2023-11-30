package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.CalculationRequest;
import com.example.HealthyDog.Services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public String calculate(@RequestBody CalculationRequest request) {
        double rer = calculatorService.calculateRER(request.getWeight());
        double k = calculatorService.validateAndSetK(request.getActivityLevel());
        double dailyCalories = calculatorService.calculateDailyCalories(rer, k);
        double dryFoodGrams = calculatorService.calculateDryFoodGrams(dailyCalories, request.getDryFoodCalorieContent());
        double cannedFoodGrams = calculatorService.calculateCannedFoodGrams(dailyCalories, request.getCannedFoodCalorieContent());

        return String.format("RER: %.2f, Daily Calories: %.2f, Dry Food Grams: %.2f, Canned Food Grams: %.2f",
                rer, dailyCalories, dryFoodGrams, cannedFoodGrams);
    }
}
