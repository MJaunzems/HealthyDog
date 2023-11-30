package com.example.HealthyDog.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class PetEntity {

    @Id
    private long pet_id;
    private long user_id;
    private String pet_type;
    private String pet_name;
    private String pet_activity;
    private double pet_weight;
    private int pet_age;
    private String pet_illness;
    private int pet_price_range;

    public PetEntity(long pet_id, long user_id, String pet_type, String pet_name, String pet_activity, double pet_weight, int pet_age, String pet_illness, int pet_price_range) {
        this.pet_id = pet_id;
        this.user_id = user_id;
        this.pet_type = pet_type;
        this.pet_name = pet_name;
        this.pet_activity = pet_activity;
        this.pet_weight = pet_weight;
        this.pet_age = pet_age;
        this.pet_illness = pet_illness;
        this.pet_price_range = pet_price_range;
    }

}
