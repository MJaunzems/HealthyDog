package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Repositories.CannedFoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CannedFoodService {

    private final CannedFoodRepository cannedFoodRepository;
    private static final Logger logger = LoggerFactory.getLogger(CannedFoodService.class);

    @Autowired
    public CannedFoodService(CannedFoodRepository cannedFoodRepository) {
        this.cannedFoodRepository = cannedFoodRepository;
    }

    public List<CannedFoodEntity> findByCannedCompany(String cannedCompany) {
        try {
            return cannedFoodRepository.findByCannedCompany(cannedCompany);
        } catch (Exception e) {
            logger.error("Error occurred while fetching canned foods by company: {}", cannedCompany, e);
            throw new RuntimeException("Error occurred while fetching canned foods by company: " + cannedCompany, e);
        }
    }
}
