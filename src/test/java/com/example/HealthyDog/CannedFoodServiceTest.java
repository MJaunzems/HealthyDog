package com.example.HealthyDog;

import com.example.HealthyDog.Entities.CannedFoodEntity;
import com.example.HealthyDog.Repositories.CannedFoodRepository;
import com.example.HealthyDog.Services.CannedFoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class CannedFoodServiceTest {

    @Mock
    private CannedFoodRepository cannedFoodRepository;

    @InjectMocks
    private CannedFoodService cannedFoodService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByCannedCompany() {
        // Arrange
        String cannedCompany = "SomeCompany";
        List<CannedFoodEntity> expectedList = Collections.singletonList(new CannedFoodEntity(1L, cannedCompany, "SomeAgeType", 10.0, 0.5, 20.0, "SomePetType", "SomeImageName"));

        when(cannedFoodRepository.findByCannedCompany(cannedCompany)).thenReturn(expectedList);

        // Act
        List<CannedFoodEntity> actualList = cannedFoodService.findByCannedCompany(cannedCompany);

        // Assert
        assertEquals(expectedList, actualList);
    }

/*
@Mock: This annotation creates a mock for the CannedFoodRepository.
@InjectMocks: This annotation injects the mock repository into the CannedFoodService.
@BeforeEach: This method is annotated to run before each test and initializes the mock objects.
testFindByCannedCompany(): This test method checks if the service correctly interacts with the
repository, ensuring that the expected list of products is returned when searching by company.
*/

    @Test
    void testFindByCannedCompanyEmptyList() {
        String cannedCompany = "NonExistentCompany";
        when(cannedFoodRepository.findByCannedCompany(cannedCompany)).thenReturn(Collections.emptyList());
        List<CannedFoodEntity> actualList = cannedFoodService.findByCannedCompany(cannedCompany);
        assertTrue(actualList.isEmpty());
    }
}