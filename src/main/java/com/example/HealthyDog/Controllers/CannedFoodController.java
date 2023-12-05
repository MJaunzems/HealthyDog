package com.example.HealthyDog.Controllers;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Services.CannedFoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cannedfoods")
public class CannedFoodController {

    private final CannedFoodService cannedFoodService;
    private static final Logger logger = LoggerFactory.getLogger(CannedFoodController.class);

    @Autowired
    public CannedFoodController(CannedFoodService cannedFoodService) {
        this.cannedFoodService = cannedFoodService;
    }

    @GetMapping("/findByCannedCompany/{cannedCompany}")
    public List<CannedFoodEntity> findByCannedCompany(@PathVariable String cannedCompany) {
        try {
            return cannedFoodService.findByCannedCompany(cannedCompany);
        } catch (Exception e) {
            logger.error("Error occurred while processing request for canned foods by company: {}", cannedCompany, e);
            return List.of();
        }
    }
}
