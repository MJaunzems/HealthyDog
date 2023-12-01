package com.example.HealthyDog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class CannedFoodIngredientsEntity {

    @Id
    @Column(name="ingredient_id")
    private long ingredientId;
    @Column(name="canned_id")
    private long cannedId;
    @Column(name="ingredient_name")
    private String ingredientName;

    public CannedFoodIngredientsEntity(long ingredientId, long cannedId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.cannedId = cannedId;
        this.ingredientName = ingredientName;
    }
}
