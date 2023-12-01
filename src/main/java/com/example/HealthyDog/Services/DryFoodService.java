package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Repositories.DryFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DryFoodService {

    private final DryFoodRepository dryFoodRepository;

    @Autowired
    public DryFoodService(DryFoodRepository dryFoodRepository) {
        this.dryFoodRepository = dryFoodRepository;
    }

    public List<DryFoodEntity> findByDryCompany(String dryCompany) {
        return dryFoodRepository.findByDry_company(dryCompany);
    }

}
