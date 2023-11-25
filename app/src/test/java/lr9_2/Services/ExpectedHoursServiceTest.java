package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.MonthlyExpectedWorkingHours;
import lr9_2.Repositories.ExpectedHoursRepo;
import lr9_2.services.implementations.ExpectedHoursServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExpectedHoursServiceTest {

    @Mock
    private ExpectedHoursRepo expectedHoursRepo;

    @InjectMocks
    private ExpectedHoursServiceImpl expectedHoursService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllExpectedHours() {
        // Arrange
        MonthlyExpectedWorkingHours expectedHours1 = new MonthlyExpectedWorkingHours("Feb", 40, null);
        MonthlyExpectedWorkingHours expectedHours2 = new MonthlyExpectedWorkingHours("Feb", 40, null);
        List<MonthlyExpectedWorkingHours> expectedHoursList = Arrays.asList(expectedHours1, expectedHours2);

        when(expectedHoursRepo.findAll()).thenReturn(expectedHoursList);

        // Act
        List<MonthlyExpectedWorkingHours> result = expectedHoursService.getAllExpectedHours();

        // Assert
        assertEquals(expectedHoursList, result);
    }

    @Test
    void createExpectedHours() {
        // Arrange
        MonthlyExpectedWorkingHours expectedHours = new MonthlyExpectedWorkingHours("Feb", 40, null);

        when(expectedHoursRepo.save(expectedHours)).thenReturn(expectedHours);

        // Act
        MonthlyExpectedWorkingHours result = expectedHoursService.createExpectedHours(expectedHours);

        // Assert
        assertEquals(expectedHours, result);
    }

    @Test
    void getExpectedHoursById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        MonthlyExpectedWorkingHours expectedHours = new MonthlyExpectedWorkingHours("Feb", 40, null);

        when(expectedHoursRepo.findById(id)).thenReturn(Optional.of(expectedHours));

        // Act
        MonthlyExpectedWorkingHours result = expectedHoursService.getExpectedHoursById(id);

        // Assert
        assertEquals(expectedHours, result);
    }

    @Test
    void getExpectedHoursById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(expectedHoursRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> expectedHoursService.getExpectedHoursById(id));

        assertEquals("Monthly Expected Working Hours with id: " + id + " was not found.", exception.getMessage());
    }
}
