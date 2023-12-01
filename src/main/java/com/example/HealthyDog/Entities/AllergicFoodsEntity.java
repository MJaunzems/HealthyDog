package com.example.HealthyDog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class AllergicFoodsEntity {

    @Id
    private long allergicId;
    private long petId;
    private long ingredientId;
    private String allergicName;

    public AllergicFoodsEntity(long allergicId, long petId, long ingredientId, String allergicName) {
        this.allergicId = allergicId;
        this.petId = petId;
        this.ingredientId = ingredientId;
        this.allergicName = allergicName;
    }
}
