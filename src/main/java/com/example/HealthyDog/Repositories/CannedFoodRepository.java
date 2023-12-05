package com.example.HealthyDog.Repositories;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CannedFoodRepository extends JpaRepository<CannedFoodEntity, Long> {

    Page<CannedFoodEntity> findAll(Pageable pageable);

}
