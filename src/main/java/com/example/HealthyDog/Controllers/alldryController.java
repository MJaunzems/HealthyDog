package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.DryFoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class alldryController {

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    private final DryFoodService dryFoodService;
    private static final Logger logger = LoggerFactory.getLogger(CannedFoodController.class);

    @Autowired
    public alldryController(DryFoodService dryFoodService) {
        this.dryFoodService = dryFoodService;
    }

    @GetMapping("/drylist")
    public String showAllCannedFoods(Model model) {
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);
        List<DryFoodEntity> dryFoods = dryFoodService.getAllDryFoods();
        model.addAttribute("dryFoods", dryFoods);
        return "/drylist";
    }
}