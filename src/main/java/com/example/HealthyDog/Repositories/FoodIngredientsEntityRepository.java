package com.example.HealthyDog.Repositories;

import com.example.HealthyDog.Entities.FoodIngredientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodIngredientsEntityRepository extends JpaRepository<FoodIngredientsEntity, Long> {
    List<FoodIngredientsEntity> findAllById(Long id);
}