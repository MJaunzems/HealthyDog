package com.example.HealthyDog.repository;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CannedFoodRepository extends CrudRepository<CannedFoodEntity, Long> {
    List<CannedFoodEntity> findByCannedCompany(String cannedCompany);

}
