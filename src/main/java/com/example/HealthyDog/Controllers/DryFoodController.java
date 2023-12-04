package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Services.DryFoodService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DryFoodController {

    private final DryFoodService dryFoodService;

    @Autowired
    public DryFoodController(DryFoodService dryFoodService) {
        this.dryFoodService = dryFoodService;
    }

    @GetMapping("/dryfoods")
    public String showDryFoods(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "51") int size) {
        Page<DryFoodEntity> dryFoods = dryFoodService.getTopDryFoods(page, size);
        model.addAttribute("dryFoods", dryFoods.getContent());
        return "dryfoods";
    }
}
