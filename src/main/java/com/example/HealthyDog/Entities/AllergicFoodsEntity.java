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
    private long allergic_id;
    private long pet_id;
    private long ingredient_id;
    private String allergic_name;

    public AllergicFoodsEntity(long allergic_id, long pet_id, long ingredient_id, String allergic_name) {
        this.allergic_id = allergic_id;
        this.pet_id = pet_id;
        this.ingredient_id = ingredient_id;
        this.allergic_name = allergic_name;
    }
}
