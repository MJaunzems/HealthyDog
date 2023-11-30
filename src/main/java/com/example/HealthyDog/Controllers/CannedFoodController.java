package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Services.CannedFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cannedfoods")
public class CannedFoodController {

    private final CannedFoodService cannedFoodService;

    @Autowired
    public CannedFoodController(CannedFoodService cannedFoodService) {
        this.cannedFoodService = cannedFoodService;
    }

    @GetMapping("/findByCannedCompany/{cannedCompany}")
    public List<CannedFoodEntity> findByCannedCompany(@PathVariable String cannedCompany) {
        return cannedFoodService.findByCannedCompany(cannedCompany);
    }

}
