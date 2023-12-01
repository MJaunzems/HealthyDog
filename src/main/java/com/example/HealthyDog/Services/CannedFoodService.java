package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Repositories.CannedFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CannedFoodService {

    private final CannedFoodRepository cannedFoodRepository;

    @Autowired
    public CannedFoodService(CannedFoodRepository cannedFoodRepository) {
        this.cannedFoodRepository = cannedFoodRepository;
    }

    public List<CannedFoodEntity> findByCannedCompany(String cannedCompany) {
        return cannedFoodRepository.findByCannedCompany(cannedCompany);
    }

}
