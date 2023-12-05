package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Repositories.CannedFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CannedFoodService {

    private final CannedFoodRepository cannedFoodRepository;

    @Autowired
    public CannedFoodService(CannedFoodRepository cannedFoodRepository) {
        this.cannedFoodRepository = cannedFoodRepository;
    }

    public Page<CannedFoodEntity> getTopCannedFoods(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return cannedFoodRepository.findAll(pageRequest);
    }

}
