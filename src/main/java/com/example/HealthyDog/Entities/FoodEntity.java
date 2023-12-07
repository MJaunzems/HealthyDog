package com.example.HealthyDog.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "food_entity")
public class FoodEntity {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "company")
    private String company;
    @Column(name = "age_type")
    private String ageType;
    @Column(name = "price")
    private double price;
    @Column(name = "weight")
    private double weight;
    @Column(name = "calorie")
    private double calorie;
    @Column(name = "pet_type")
    private String petType;
    @Column(name = "img_name")
    private String imageName;

    public FoodEntity(long id, String company, String ageType, double price, double weight, double calorie, String petType, String imageName) {
        this.id = id;
        this.company = company;
        this.ageType = ageType;
        this.price = price;
        this.weight = weight;
        this.calorie = calorie;
        this.petType = petType;
        this.imageName = imageName;
    }
}
