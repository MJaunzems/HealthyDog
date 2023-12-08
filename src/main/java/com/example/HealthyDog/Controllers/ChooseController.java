package com.example.HealthyDog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class   ChooseController {

    @GetMapping("/choose-animal")
    public String chooseAnimal() {
        return "chooseAnimal";
    }

    @GetMapping("/")
    public String chooseSomething(SessionStatus status) {
        status.setComplete();
        return "chooseAnimal";
    }

}
