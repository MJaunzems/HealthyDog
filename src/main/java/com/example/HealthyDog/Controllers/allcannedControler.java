package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.CannedFoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class allcannedControler {

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    private final CannedFoodService cannedFoodService;
    private static final Logger logger = LoggerFactory.getLogger(CannedFoodController.class);

    @Autowired
    public allcannedControler(CannedFoodService cannedFoodService) {
        this.cannedFoodService = cannedFoodService;
    }

    @GetMapping("/cannedlist")
    public String showAllCannedFoods(Model model) {
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);
        List<CannedFoodEntity> cannedFoods = cannedFoodService.getAllCannedFoods();
        model.addAttribute("cannedFoods", cannedFoods);
        return "/cannedlist";
    }
}