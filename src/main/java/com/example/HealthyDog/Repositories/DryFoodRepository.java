package com.example.HealthyDog.Repositories;

import com.example.HealthyDog.Entities.DryFoodEntity;
import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DryFoodRepository extends JpaRepository<DryFoodEntity, Long> {
    Page<DryFoodEntity> findAll(Pageable pageable);
}
