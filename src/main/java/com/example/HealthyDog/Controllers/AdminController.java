package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Repositories.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/admin")
    public String showAdmin(Model model) {
        model.addAttribute("foodEntity", new FoodEntity());
        List<FoodEntity> foods = foodRepository.findAll();
        model.addAttribute("foods", foods);
        return "admin";
    }

    @PostMapping("/admin/add-food")
    public String addFood(@ModelAttribute FoodEntity foodEntity,
                          RedirectAttributes redirectAttributes) {
        boolean canSave = true;
        if(foodEntity.getPrice() <= 0){
            redirectAttributes.addFlashAttribute("errorPrice", "Enter valid price.");
            canSave = false;
        }
        if(foodEntity.getWeight() <= 0){
            redirectAttributes.addFlashAttribute("errorWeight", "Enter valid weight.");
            canSave = false;
        }
        if(foodEntity.getCalorie() <= 0){
            redirectAttributes.addFlashAttribute("errorCalorie", "Enter valid calories.");
            canSave = false;
        }
        if(canSave) foodRepository.save(foodEntity);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete-food")
    public String deleteFood(@RequestParam long id,
                             RedirectAttributes redirectAttributes) {
            if (foodRepository.existsById(id)) {
                foodRepository.deleteById(id);
            } else {
                LOGGER.error("Error deleting food by id.");
                redirectAttributes.addFlashAttribute("error", "Enter valid id.");
        }
        return "redirect:/admin";
    }
}
