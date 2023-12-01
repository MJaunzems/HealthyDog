package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import com.example.HealthyDog.Repositories.AllergicFoodsRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    private AllergicFoodsRepository allergicFoodsRepository;

    @PostMapping("/processForm")
    public ModelAndView form(Model model){
        Iterable<AllergicFoodsEntity> options = allergicFoodsRepository.findAll();
        model.addAttribute("options", options);
        return new ModelAndView("form");
    }

    @GetMapping("/form")
    public ModelAndView form(@RequestParam("type") String type, HttpSession session, Model model){
        session.setAttribute("type", type);
        return new ModelAndView("redirect:/form");
    }
}
