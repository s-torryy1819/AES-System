package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.Employee;
import lr9_2.DTO.Schedule;
import lr9_2.Repositories.ScheduleRepo;
import lr9_2.services.implementations.ScheduleServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScheduleServiceTest {

    @Mock
    private ScheduleRepo scheduleRepo;

    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    Employee employee = new Employee("Mr Egon", "Sachse", null, null, null, null, null, null);

    @Test
    void getAllSchedules() {
        // Arrange
        Schedule schedule1 = new Schedule(null, null, employee);
        Schedule schedule2 = new Schedule(null, null, employee);
        List<Schedule> scheduleList = Arrays.asList(schedule1, schedule2);

        when(scheduleRepo.findAll()).thenReturn(scheduleList);

        // Act
        List<Schedule> result = scheduleService.getAllSchedules();

        // Assert
        assertEquals(scheduleList, result);
    }

    @Test
    void createSchedule() {
        // Arrange
        Schedule schedule = new Schedule(null, null, employee);

        when(scheduleRepo.save(schedule)).thenReturn(schedule);

        // Act
        Schedule result = scheduleService.createSchedule(schedule);

        // Assert
        assertEquals(schedule, result);
    }

    @Test
    void deleteSchedule_existingId() {
        // Arrange
        Integer id = 1;
        Schedule schedule = new Schedule(null, null, employee);

        when(scheduleRepo.findById(id)).thenReturn(Optional.of(schedule));

        // Act
        assertDoesNotThrow(() -> scheduleService.deleteSchedule(id));

        // Assert
        verify(scheduleRepo, times(1)).delete(schedule);
    }

    @Test
    void deleteSchedule_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(scheduleRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> scheduleService.deleteSchedule(id));

        assertEquals("Card with id: " + id + " was not found.", exception.getMessage());
    }

    @Test
    void getScheduleById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        Schedule schedule = new Schedule(null, null, employee);

        when(scheduleRepo.findById(id)).thenReturn(Optional.of(schedule));

        // Act
        Schedule result = scheduleService.getScheduleById(id);

        // Assert
        assertEquals(schedule, result);
    }

    @Test
    void getScheduleById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(scheduleRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> scheduleService.getScheduleById(id));

        assertEquals("Card with id: " + id + " was not found.", exception.getMessage());
    }
}
