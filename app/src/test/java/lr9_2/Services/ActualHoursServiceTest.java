package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.WorkedHours;
import lr9_2.Repositories.WorkedHoursRepo;
import lr9_2.services.implementations.ActualHoursServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActualHoursServiceTest {

    @Mock
    private WorkedHoursRepo workedHoursRepo;

    @InjectMocks
    private ActualHoursServiceImpl actualHoursService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllActualHours() {
        // Arrange
        WorkedHours workedHours1 = new WorkedHours(12, null);
        WorkedHours workedHours2 = new WorkedHours(12, null);
        List<WorkedHours> workedHoursList = Arrays.asList(workedHours1, workedHours2);

        when(workedHoursRepo.findAll()).thenReturn(workedHoursList);

        // Act
        List<WorkedHours> result = actualHoursService.getAllActualHours();

        // Assert
        assertEquals(workedHoursList, result);
    }

    @Test
    void addActualHours() {
        // Arrange
        WorkedHours workedHours = new WorkedHours(15, null);

        when(workedHoursRepo.save(workedHours)).thenReturn(workedHours);

        // Act
        WorkedHours result = actualHoursService.addActualHours(workedHours);

        // Assert
        assertEquals(workedHours, result);
    }

    @Test
    void deleteActualHours_existingId() {
        // Arrange
        Integer id = 1;
        WorkedHours workedHours = new WorkedHours(16, null);

        when(workedHoursRepo.findById(id)).thenReturn(Optional.of(workedHours));

        // Act
        assertDoesNotThrow(() -> actualHoursService.deleteActualHours(id));

        // Assert
        verify(workedHoursRepo, times(1)).delete(workedHours);
    }

    @Test
    void deleteActualHours_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(workedHoursRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> actualHoursService.deleteActualHours(id));

        assertEquals("WorkedHours with id: " + id + " was not found.", exception.getMessage());
    }

    @Test
    void getActualHoursById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        WorkedHours workedHours = new WorkedHours(25, null);

        when(workedHoursRepo.findById(id)).thenReturn(Optional.of(workedHours));

        // Act
        WorkedHours result = actualHoursService.getActualHoursById(id);

        // Assert
        assertEquals(workedHours, result);
    }

    @Test
    void getActualHoursById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(workedHoursRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> actualHoursService.getActualHoursById(id));

        assertEquals("WorkedHours with id: " + id + " was not found.", exception.getMessage());
    }
}
