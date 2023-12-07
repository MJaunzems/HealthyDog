package com.example.HealthyDog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodIngredientsEntity {

    @Id
    @Column(name = "ingredient_id")
    private long ingredientId;
    @Column(name = "id")
    private long id;
    @Column(name = "ingredient_name")
    private String ingredientName;

}
