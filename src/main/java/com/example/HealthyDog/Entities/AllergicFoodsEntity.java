package com.example.HealthyDog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class AllergicFoodsEntity {

    @Id
    @Column(name="allergic_id")
    private long allergicId;
    //@Column(name="pet_id")
    //private long petId;
    @Column(name="ingredient_id")
    private long ingredientId;
    @Column(name="allergic_name")
    private String allergicName;

    public AllergicFoodsEntity(long allergicId, long petId, long ingredientId, String allergicName) {
        this.allergicId = allergicId;
        //this.petId = petId;
        this.ingredientId = ingredientId;
        this.allergicName = allergicName;
    }
}
