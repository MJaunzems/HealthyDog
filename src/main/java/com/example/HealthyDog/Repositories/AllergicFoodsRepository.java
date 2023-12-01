package com.example.HealthyDog.Repositories;

import com.example.HealthyDog.Entities.AllergicFoodsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergicFoodsRepository extends CrudRepository<AllergicFoodsEntity, Long> {
    List<AllergicFoodsEntity> findByAllergic_name(String allergicName);

}
