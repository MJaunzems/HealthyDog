package com.example.HealthyDog;

public class Food {
    private String name;
    private double weight;
    private int dailyPortion;


    public Food(String name, double weight, int dailyPortion) {
        this.name = name;
        this.weight = weight;
        this.dailyPortion = dailyPortion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getDailyPortion() {
        return dailyPortion;
    }

    public void setDailyPortion(int dailyPortion) {
        this.dailyPortion = dailyPortion;
    }
}
