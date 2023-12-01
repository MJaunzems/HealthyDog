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
    private long ingredientId;
    private long cannedId;
    private String ingredientName;

    public CannedFoodIngredientsEntity(long ingredientId, long cannedId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.cannedId = cannedId;
        this.ingredientName = ingredientName;
    }
}
