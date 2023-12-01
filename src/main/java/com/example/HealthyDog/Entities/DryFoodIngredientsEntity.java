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
    private long ingredientId;
    private long dryId;
    private String ingredientName;

    public DryFoodIngredientsEntity(long ingredientId, long dryId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.dryId = dryId;
        this.ingredientName = ingredientName;
    }
}
