package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import com.example.HealthyDog.Services.CannedFoodService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CannedFoodController {

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;
    private final CannedFoodService cannedFoodService;

    @Autowired
    public CannedFoodController(CannedFoodService cannedFoodService) {
        this.cannedFoodService = cannedFoodService;
    }

    @PostMapping("/secondProcessType")
    public ModelAndView form(@RequestParam String type, HttpSession session){
        session.setAttribute("type", type);
        return new ModelAndView("redirect:/cannedfoods");
    }

    @PostMapping("/secondProcessForm")
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
        return new ModelAndView("redirect:/cannedfoods");
    }


//    @GetMapping("/findByCannedCompany/{cannedCompany}")
//    public List<CannedFoodEntity> findByCannedCompany(@PathVariable String cannedCompany) {
//        return cannedFoodService.findByCannedCompany(cannedCompany);
//    }


    @GetMapping("/cannedfoods")
    public String showCannedFoods(Model model,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "13") int size) {
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);
        Page<CannedFoodEntity> cannedFoods = cannedFoodService.getTopCannedFoods(page, size);
        model.addAttribute("cannedFoods", cannedFoods.getContent());
        return "cannedfoods";
    }


}
