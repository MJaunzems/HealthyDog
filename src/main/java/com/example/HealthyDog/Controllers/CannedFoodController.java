package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.CannedFoodService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CannedFoodController {

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    private final CannedFoodService cannedFoodService;
    private static final Logger logger = LoggerFactory.getLogger(CannedFoodController.class);

    @Autowired
    public CannedFoodController(CannedFoodService cannedFoodService) {
        this.cannedFoodService = cannedFoodService;
    }

    @GetMapping("/findByCannedCompany/{cannedCompany}")
    public List<CannedFoodEntity> findByCannedCompany(@PathVariable String cannedCompany) {
        try {
            return cannedFoodService.findByCannedCompany(cannedCompany);
        } catch (Exception e) {
            logger.error("Error occurred while processing request for canned foods by company: {}", cannedCompany, e);
            return List.of();
        }
    }
    @PostMapping("/secondProcessType")
    public ModelAndView form(@RequestParam String type, HttpSession session) {
        session.setAttribute("type", type);
        return new ModelAndView("redirect:/cannedfoods");
    }

    @PostMapping("/secondProcessForm")
    public ModelAndView form(@RequestParam String activity,
                             @RequestParam double weight,
                             @RequestParam int age,
                             @RequestParam String allergies,
                             @RequestParam double price,
                             HttpSession session) {
        session.setAttribute("activity", activity);
        session.setAttribute("weight", weight);
        session.setAttribute("age", age);
        session.setAttribute("allergies", allergies);
        session.setAttribute("price", price);
        return new ModelAndView("redirect:/cannedfoods");
    }



    @GetMapping("/cannedfoods")
    public String showCannedFoods(Model model,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "26") int size) {
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);
        Page<CannedFoodEntity> cannedFoods = cannedFoodService.getTopCannedFoods(page, size);
        model.addAttribute("cannedFoods", cannedFoods.getContent());
        return "cannedfoods";
    }

}
