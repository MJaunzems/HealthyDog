package com.example.HealthyDog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class DryFoodIngredientsEntity {

    @Id
    private long ingredient_id;
    private long dry_id;
    private String ingredient_name;

    public DryFoodIngredientsEntity(long ingredient_id, long dry_id, String ingredient_name) {
        this.ingredient_id = ingredient_id;
        this.dry_id = dry_id;
        this.ingredient_name = ingredient_name;
    }
}
