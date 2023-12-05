package com.example.HealthyDog.Repositories;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CannedFoodRepository extends JpaRepository<CannedFoodEntity, Long> {

    Page<CannedFoodEntity> findAll(Pageable pageable);

    List<CannedFoodEntity> findByCannedCompany(String cannedCompany);
}
