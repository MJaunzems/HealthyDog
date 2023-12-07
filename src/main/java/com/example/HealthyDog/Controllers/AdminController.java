package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/admin")
    public String showAdmin(Model model){
        model.addAttribute("foodEntity", new FoodEntity());
        List<FoodEntity> foods = foodRepository.findAll();
        model.addAttribute("foods", foods);
        return "admin";
    }
    @PostMapping("/admin/add-food")
    public String addFood(@ModelAttribute FoodEntity foodEntity){
        foodRepository.save(foodEntity);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete-food")
    public String deleteFood(@RequestParam long id){
        foodRepository.deleteById(id);
        return "redirect:/admin";
    }
}
