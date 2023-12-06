package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.CalculationRequest;
import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Services.CalculatorService;
import com.example.HealthyDog.Services.CannedFoodService;
import com.example.HealthyDog.Services.DryFoodService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CannedFoodService cannedFoodService;
    @Autowired
    private DryFoodService dryFoodService;

    @GetMapping("/calculate")
    public ModelAndView calculate(Model model, HttpSession session) {
        try {
            double rer = calculatorService.calculateRER((Double) session.getAttribute("weight"));
            double k = calculatorService.validateAndSetK((String) session.getAttribute("activity"));
            double dailyCalories = calculatorService.calculateDailyCalories(rer, k);
            List<FoodEntity> allFoods = dryFoodService.getAllFoods();
            List<FoodEntity> filteredFoods = calculatorService.filterFoods(allFoods, session);
            List<String> foodResults = new ArrayList<>();
            for (FoodEntity food : filteredFoods){
                double foodCalorieContent = food.getCalorie();
                double foodGrams = calculatorService.calculateFoodGrams(dailyCalories, foodCalorieContent);
                foodResults.add(food.getCompany() + foodGrams);
                System.out.println(foodResults);
            }
            model.addAttribute("foodResults",foodResults);
            //Page<DryFoodEntity> dryFoodsPage = DryFoodRepository.findAll(pageable);
            //Page<CannedFoodEntity> cannedFoodsPage = foodService.getAllCannedFoods(pageable);
            //double dryFoodGrams = calculatorService.calculateDryFoodGrams(dailyCalories, request.getDryFoodCalorieContent());
            //double cannedFoodGrams = calculatorService.calculateCannedFoodGrams(dailyCalories, request.getCannedFoodCalorieContent());
            //Page<>
            //model.addAttribute("calculation", )
            return new ModelAndView("redirect:/dryfoods");
        } catch (IllegalArgumentException e) {
            LOGGER.error("Invalid input: {}", e.getMessage());
            return new ModelAndView("redirect:/error?message=Invalid input. Please check your request.");
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred: {}", e.getMessage());
            return new ModelAndView("redirect:/error?message=An unexpected error occurred. Please try again later.");
        }
    }
}

