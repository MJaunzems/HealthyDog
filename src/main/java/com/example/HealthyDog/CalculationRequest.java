package com.example.HealthyDog;

public class CalculationRequest {

    private double weight;
    private String activityLevel;
    private double dryFoodCalorieContent;
    private double cannedFoodCalorieContent;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public double getDryFoodCalorieContent() {
        return dryFoodCalorieContent;
    }

    public void setDryFoodCalorieContent(double dryFoodCalorieContent) {
        this.dryFoodCalorieContent = dryFoodCalorieContent;
    }

    public double getCannedFoodCalorieContent() {
        return cannedFoodCalorieContent;
    }

    public void setCannedFoodCalorieContent(double cannedFoodCalorieContent) {
        this.cannedFoodCalorieContent = cannedFoodCalorieContent;
    }
}
