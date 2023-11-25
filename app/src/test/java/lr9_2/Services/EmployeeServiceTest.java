package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.Employee;
import lr9_2.Repositories.EmployeeRepo;
import lr9_2.services.implementations.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllEmployees() {
        // Arrange
        Employee employee1 = new Employee("Mr Max", "Fischer", null, null, null, null, null, null);
        Employee employee2 = new Employee("Mr Max", "Fischer", null, null, null, null, null, null);
        List<Employee> employeeList = Arrays.asList(employee1, employee2);

        when(employeeRepo.findAll()).thenReturn(employeeList);

        // Act
        List<Employee> result = employeeService.getAllEmployees();

        // Assert
        assertEquals(employeeList, result);
    }

    @Test
    void createEmployee() {
        // Arrange
        Employee employee = new Employee("Mr Max", "Fischer", null, null, null, null, null, null);

        when(employeeRepo.save(employee)).thenReturn(employee);

        // Act
        Employee result = employeeService.createEmployee(employee);

        // Assert
        assertEquals(employee, result);
    }

    @Test
    void deleteEmployee_existingId() {
        // Arrange
        Integer id = 1;
        Employee employee = new Employee("Mr Max", "Fischer", null, null, null, null, null, null);

        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));

        // Act
        assertDoesNotThrow(() -> employeeService.deleteEmployee(id));

        // Assert
        verify(employeeRepo, times(1)).delete(employee);
    }

    @Test
    void deleteEmployee_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(employeeRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> employeeService.deleteEmployee(id));

        assertEquals("Employee with id: " + id + " was not found.", exception.getMessage());
    }

    @Test
    void getEmployeeById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        Employee employee = new Employee("Mr Max", "Fischer", null, null, null, null, null, null);

        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));

        // Act
        Employee result = employeeService.getEmployeeById(id);

        // Assert
        assertEquals(employee, result);
    }

    @Test
    void getEmployeeById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(employeeRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> employeeService.getEmployeeById(id));

        assertEquals("Employee with id: " + id + " was not found.", exception.getMessage());
    }
}
