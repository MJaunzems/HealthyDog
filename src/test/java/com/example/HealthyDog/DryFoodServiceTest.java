package com.example.HealthyDog;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.example.HealthyDog.Entities.DryFoodEntity;
import com.example.HealthyDog.Repositories.DryFoodRepository;
import com.example.HealthyDog.Services.DryFoodService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
class DryFoodServiceTest {

    @Mock
    private DryFoodRepository dryFoodRepository;

    @InjectMocks
    private DryFoodService dryFoodService;

    @Test
    void testGetTopDryFoods() {
        // Arrange
        int page = 0;
        int size = 10;

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<DryFoodEntity> expectedPage = new PageImpl<>(Arrays.asList(new DryFoodEntity(), new DryFoodEntity()));

        when(dryFoodRepository.findAll(pageRequest)).thenReturn(expectedPage);

        // Act
        Page<DryFoodEntity> resultPage = dryFoodService.getTopDryFoods(page, size);

        // Assert
        assertEquals(expectedPage, resultPage);
    }

    @Test
    void testGetAllDryFoods() {
        // Arrange
        List<DryFoodEntity> expectedDryFoods = Arrays.asList(new DryFoodEntity(), new DryFoodEntity());

        when(dryFoodRepository.findAll()).thenReturn(expectedDryFoods);

        // Act
        List<DryFoodEntity> resultDryFoods = dryFoodService.getAllDryFoods();

        // Assert
        assertEquals(expectedDryFoods, resultDryFoods);
    }

    @Test
    void testGetAllDryFoods_Exception() {
        // Arrange
        when(dryFoodRepository.findAll()).thenThrow(new RuntimeException("Test Exception"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> dryFoodService.getAllDryFoods());
    }
}
