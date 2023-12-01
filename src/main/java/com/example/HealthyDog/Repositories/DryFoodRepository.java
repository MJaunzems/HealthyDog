package com.example.HealthyDog.Repositories;

import com.example.HealthyDog.Entities.DryFoodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DryFoodRepository extends CrudRepository<DryFoodEntity, Long> {
    List<DryFoodEntity> findByDryCompany(String dryCompany);

}
