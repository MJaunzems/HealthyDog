package com.example.HealthyDog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @GetMapping("/choose-animal")
    public String chooseAnimal() {
        return "chooseAnimal";
    }

    @GetMapping("/")
    public String chooseSomething() {
        return "chooseAnimal";
    }

    @PostMapping("/process-animal")
    @ResponseBody
    public String processAnimal(@RequestParam("animal") String animal) {
        return "Your choice: " + animal;
    }

}
