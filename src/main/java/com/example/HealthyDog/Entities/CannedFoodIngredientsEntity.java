package com.example.HealthyDog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class CannedFoodIngredientsEntity {

    @Id
    private long ingredient_id;
    private long canned_id;
    private String ingredient_name;

    public CannedFoodIngredientsEntity(long ingredient_id, long canned_id, String ingredient_name) {
        this.ingredient_id = ingredient_id;
        this.canned_id = canned_id;
        this.ingredient_name = ingredient_name;
    }
}
