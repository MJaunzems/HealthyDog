package com.example.HealthyDog.Services;

import com.example.HealthyDog.Entities.*;
import com.example.HealthyDog.Repositories.DryFoodRepository;
import com.example.HealthyDog.Repositories.FoodIngredientsEntityRepository;
import com.example.HealthyDog.Repositories.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DryFoodService {

    private final DryFoodRepository dryFoodRepository;
    private final FoodRepository foodRepository;
    private static final Logger logger = LoggerFactory.getLogger(CannedFoodService.class);
    private final FoodIngredientsEntityRepository foodIngredientsEntityRepository;

    @Autowired
    public DryFoodService(DryFoodRepository dryFoodRepository, FoodRepository foodRepository,
                          FoodIngredientsEntityRepository foodIngredientsEntityRepository) {
        this.dryFoodRepository = dryFoodRepository;
        this.foodRepository = foodRepository;
        this.foodIngredientsEntityRepository = foodIngredientsEntityRepository;
    }

    public Page<DryFoodEntity> getTopDryFoods(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return dryFoodRepository.findAll(pageRequest);
    }

    public List<DryFoodEntity> getAllDryFoods() {
        try {
            return dryFoodRepository.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all dry foods", e);
            throw new RuntimeException("Error occurred while fetching all dry foods", e);
        }
    }

    public List<FoodEntity> getById(long id){
        return foodRepository.findById(id);
    }

    public List<FoodEntity> getAllFoods(){
        return foodRepository.findAll();
    }

    public List<FoodIngredientsEntity> getAllIngredientsById(Long id) {
        return foodIngredientsEntityRepository.findAllById(id);
    }
}
