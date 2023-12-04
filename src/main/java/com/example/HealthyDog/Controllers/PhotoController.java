package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Repositories.DryFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhotoController {

    @Autowired
    public DryFoodRepository repository;

    @GetMapping("/all")
    public ModelAndView form(Model model) {
        model.addAttribute("dryFoods", repository.findAll());
        return new ModelAndView("photoTest");
    }

}
