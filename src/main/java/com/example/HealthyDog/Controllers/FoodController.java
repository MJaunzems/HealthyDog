package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;

    @PostMapping("/processType")
    public ModelAndView form(@RequestParam String type, HttpSession session){
        session.setAttribute("type", type);
        return new ModelAndView("redirect:/foodCalc");
    }

    @PostMapping("/processForm")
    public ModelAndView form(@RequestParam String activity,
                             @RequestParam double weight,
                             @RequestParam int age,
                             @RequestParam String allergies,
                             @RequestParam double price,
                             HttpSession session){
        session.setAttribute("activity", activity);
        session.setAttribute("weight", weight);
        session.setAttribute("age", age);
        session.setAttribute("allergies", allergies);
        session.setAttribute("price", price);
        return new ModelAndView("redirect:/foodCalc");
    }

    @GetMapping("/foodCalc")
    public ModelAndView showFoods(HttpSession session, Model model) {
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);

        FoodEntity food1 = new FoodEntity("Dog Food", 500, 2, "");
        FoodEntity food2 = new FoodEntity("Cat Food", 300, 1,"");
        FoodEntity food3 = new FoodEntity("Premium Dog Food", 700, 3,"");
        FoodEntity food4 = new FoodEntity("Fish Flakes", 150, 5,"");
        FoodEntity food5 = new FoodEntity("Bird Seeds", 200, 1,"");
        FoodEntity food6 = new FoodEntity("Prime Dog can food", 400, 2,"");
        FoodEntity food7 = new FoodEntity("Dry cat food", 650, 5,"");
        FoodEntity food8 = new FoodEntity("Can chicken food for cats", 600, 1,"");
        FoodEntity food9 = new FoodEntity("Food for all animals", 100, 2, "");

        List<FoodEntity> foods = new ArrayList<>();
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

        return new ModelAndView("index");
    }
}
