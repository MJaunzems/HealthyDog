package com.example.HealthyDog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class DryFoodIngredientsEntity {

    @Id
    @Column(name="ingredient_id")
    private long ingredientId;
    @Column(name="dry_id")
    private long dryId;
    @Column(name="ingredient_name")
    private String ingredientName;

    public DryFoodIngredientsEntity(long ingredientId, long dryId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.dryId = dryId;
        this.ingredientName = ingredientName;
    }
}
