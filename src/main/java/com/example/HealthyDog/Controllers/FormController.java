package com.example.HealthyDog.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {

    @GetMapping("/form")
    public ModelAndView form(){
        return new ModelAndView("form");
    }

    @PostMapping("/processForm")
    public ModelAndView form(@RequestParam("type") String type, HttpSession session){
        session.setAttribute("type", type);
        return new ModelAndView("form");
    }
}
