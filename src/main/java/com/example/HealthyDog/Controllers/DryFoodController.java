package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.DryFoodService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DryFoodController {

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    private final DryFoodService dryFoodService;

    @Autowired
    public DryFoodController(DryFoodService dryFoodService) {
        this.dryFoodService = dryFoodService;
    }

    @PostMapping("/processType")
    public ModelAndView form(@RequestParam String type, HttpSession session){
        session.setAttribute("type", type);
        return new ModelAndView("redirect:/dryfoods");
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
        return new ModelAndView("redirect:/dryfoods");
    }

    @GetMapping("/dryfoods")
    public String showDryFoods(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "71") int size) {
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);
        Page<DryFoodEntity> dryFoods = dryFoodService.getTopDryFoods(page, size);
        model.addAttribute("dryFoods", dryFoods.getContent());
        return "dryfoods";
    }

}
