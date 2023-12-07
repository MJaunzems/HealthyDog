package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/admin")
    public String showAdmin(Model model){
        model.addAttribute("foodEntity", new FoodEntity());
        return "admin";
    }
    @PostMapping("/admin/add-food")
    public String addFood(@ModelAttribute FoodEntity foodEntity){
        foodRepository.save(foodEntity);
        return "redirect:/admin";
    }
}
