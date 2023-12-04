package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Repositories.DryFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DryFoodService {

    private final DryFoodRepository dryFoodRepository;

    @Autowired
    public DryFoodService(DryFoodRepository dryFoodRepository) {
        this.dryFoodRepository = dryFoodRepository;
    }

    public Page<DryFoodEntity> getTopDryFoods(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return dryFoodRepository.findAll(pageRequest);
    }
}
