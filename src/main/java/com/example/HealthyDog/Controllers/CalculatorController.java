package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.FoodDTO;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.CalculatorService;
import com.example.HealthyDog.Services.CannedFoodService;
import com.example.HealthyDog.Services.DryFoodService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService calculatorService;
    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    @Autowired
    private CannedFoodService cannedFoodService;
    @Autowired
    private DryFoodService dryFoodService;

    @GetMapping("/calculate")
    public String calculate(Model model, HttpSession session) {

            if (session.getAttribute("weight") == null || session.getAttribute("activity") == null) {
                session.setAttribute("weight", 10.0);
                session.setAttribute("activity", "medium_active");
                session.setAttribute("age", "Adult");
            }
            double rer = calculatorService.calculateRER((Double) session.getAttribute("weight"));
            double k = calculatorService.validateAndSetK((String) session.getAttribute("activity"));
            double dailyCalories = calculatorService.calculateDailyCalories(rer, k);
            List<FoodEntity> allFoods = dryFoodService.getAllFoods();
            List<FoodEntity> filteredFoods = calculatorService.filterFoods(allFoods, session);
            List<FoodDTO> foodResults = new ArrayList<>();
            for (FoodEntity food : filteredFoods) {
                double foodCalorieContent = food.getCalorie();
                double foodWeight = food.getWeight();
                String foodAgeType = food.getAgeType();
                double foodGrams = calculatorService.calculateFoodGrams(dailyCalories, foodCalorieContent);
                foodResults.add(new FoodDTO(food.getCompany(), foodGrams, dailyCalories, foodAgeType));
            }
            Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
            model.addAttribute("options", options);
            model.addAttribute("foodResults", foodResults);
            model.addAttribute("daily",dailyCalories);
            return "dryfoods";
        /*} catch (IllegalArgumentException e) {
            LOGGER.error("Invalid input: {}", e.getMessage());
            return new ModelAndView("redirect:/error?message=Invalid input. Please check your request.");
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred: {}", e.getMessage());
            return new ModelAndView("redirect:/error?message=An unexpected error occurred. Please try again later.");
        }*/
    }
}

