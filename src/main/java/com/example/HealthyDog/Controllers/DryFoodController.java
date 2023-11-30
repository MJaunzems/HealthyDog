package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Services.DryFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dryfoods")
public class DryFoodController {

    private final DryFoodService dryFoodService;

    @Autowired
    public DryFoodController(DryFoodService dryFoodService) {
        this.dryFoodService = dryFoodService;
    }

    @GetMapping("/findByDryCompany/{dryCompany}")
    public List<DryFoodEntity> findByDryCompany(@PathVariable String dryCompany) {
        return dryFoodService.findByDryCompany(dryCompany);
    }

}
