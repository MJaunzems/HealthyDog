package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.DryFoodService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DryFoodController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DryFoodController.class);

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    private final DryFoodService dryFoodService;

    @Autowired
    public DryFoodController(DryFoodService dryFoodService) {
        this.dryFoodService = dryFoodService;
    }

    @PostMapping("/processType")
    public ModelAndView form(@RequestParam String type, HttpSession session) {
        try {
            session.setAttribute("type", type);
            return new ModelAndView("redirect:/calculate");
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred: {}", e.getMessage());
            return new ModelAndView("redirect:/error?message=An unexpected error occurred.");
        }
    }

    @PostMapping("/processForm")
    public ModelAndView form(@RequestParam String activity,
                             @RequestParam double weight,
                             @RequestParam int age,
                             @RequestParam String allergies,
                             @RequestParam double price,
                             HttpSession session) {
        try {
            session.setAttribute("activity", activity);
            session.setAttribute("weight", weight);
            session.setAttribute("age", age);
            session.setAttribute("allergies", allergies);
            session.setAttribute("price", price);
            return new ModelAndView("redirect:/calculate");
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred: {}", e.getMessage());
            return new ModelAndView("redirect:/error?message=An unexpected error occurred.");
        }
    }

    @GetMapping("/dryfoods")
    public String showDryFoods(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "51") int size) {
        try {
            Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
            model.addAttribute("options", options);
            Page<DryFoodEntity> dryFoods = dryFoodService.getTopDryFoods(page, size);
            model.addAttribute("dryFoods", dryFoods.getContent());
            return "dryfoods";
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred: {}", e.getMessage());
            return "redirect:/error?message=An unexpected error occurred.";
        }
    }

    @GetMapping("/error")
    public String showErrorPage(@RequestParam String message, Model model) {
        model.addAttribute("errorMessage", message);
        return "error";
    }

}

