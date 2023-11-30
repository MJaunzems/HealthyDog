package com.example.HealthyDog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {

    @GetMapping("/")
    public String showFoods(Model model) {

        Food food1 = new Food("Dog Food", 500, 2);
        Food food2 = new Food("Cat Food", 300, 1);
        Food food3 = new Food("Premium Dog Food", 700, 3);
        Food food4 = new Food("Fish Flakes", 150, 5);
        Food food5 = new Food("Bird Seeds", 200, 1);
        Food food6 = new Food("Prime Dog can food", 400, 2);
        Food food7 = new Food("Dry cat food", 650, 5);
        Food food8 = new Food("Can chicken food for cats", 600, 1);
        Food food9 = new Food("Food for all animals", 100, 2);

        List<Food> foods = new ArrayList<>();
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);
        foods.add(food4);
        foods.add(food5);
        foods.add(food6);
        foods.add(food7);
        foods.add(food8);
        foods.add(food9);

        model.addAttribute("foods", foods);

        return "index";
    }
}
