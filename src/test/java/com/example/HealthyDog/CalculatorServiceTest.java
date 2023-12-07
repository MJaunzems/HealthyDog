package com.example.HealthyDog;

import com.example.HealthyDog.Entities.FoodEntity;
import com.example.HealthyDog.Entities.FoodIngredientsEntity;
import com.example.HealthyDog.Services.CalculatorService;
import com.example.HealthyDog.Services.DryFoodService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
class CalculatorServiceTest {

    @InjectMocks
    private CalculatorService calculatorService;

    @Mock
    private DryFoodService dryFoodService;

    @Test
    void testCalculateFoodGrams() {
        // Arrange
        double dailyCalories = 1000.0;
        double foodCalorieContent = 200.0;

        // Act
        double result = calculatorService.calculateFoodGrams(dailyCalories, foodCalorieContent);

        // Assert
        assertEquals(500.0, result, 0.001); // Assuming a simple ratio for the test
    }


    @Test
    void testFilterFoods() {
        // Arrange
        FoodEntity food1 = new FoodEntity();
        food1.setPetType("dog");
        food1.setAgeType("Adult");

        FoodEntity food2 = new FoodEntity();
        food2.setPetType("cat");
        food2.setAgeType("Puppy");

        List<FoodEntity> allFoods = List.of(food1, food2);

        HttpSession session = Mockito.mock(HttpSession.class);
        when(session.getAttribute(eq("type"))).thenReturn("dog");
        when(session.getAttribute(eq("age"))).thenReturn("Adult");

        FoodIngredientsEntity ingredient1 = new FoodIngredientsEntity();
        ingredient1.setIngredientName("allergy1");

        FoodIngredientsEntity ingredient2 = new FoodIngredientsEntity();
        ingredient2.setIngredientName("allergy3");

        when(dryFoodService.getAllIngredientsById(any())).thenReturn(List.of(ingredient1, ingredient2));

// Act
        List<FoodEntity> result = calculatorService.filterFoods(allFoods, session);

// Assert
        assertEquals(1, result.size());
        assertEquals(food1, result.get(0));

    }
}
