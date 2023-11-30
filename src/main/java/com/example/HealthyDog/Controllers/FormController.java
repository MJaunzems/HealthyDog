package com.example.HealthyDog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @PostMapping("/form")
    public ModelAndView form(){ return new ModelAndView("form");}
}
