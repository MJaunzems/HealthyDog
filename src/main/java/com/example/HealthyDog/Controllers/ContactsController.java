package com.example.HealthyDog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {

    @GetMapping("/contacts")
    public String showContactsPage() {
        return "contacts";
    }

}

