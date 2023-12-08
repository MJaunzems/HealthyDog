package com.example.HealthyDog.Repositories;

import com.example.HealthyDog.Entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
    List<PetEntity> findByUserId(long userId);
}
