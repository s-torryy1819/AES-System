package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.Department;
import lr9_2.Repositories.DepartmentRepo;
import lr9_2.services.implementations.DepartmentServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceTest {

    @Mock
    private DepartmentRepo departmentRepo;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllDepartments() {
        // Arrange
        Department department1 = new Department("Mashine producement",
                "The creation or manufacture for sale of goods and services with exchange value", 42);
        Department department2 = new Department("Mashine producement",
                "The creation or manufacture for sale of goods and services with exchange value", 42);
        List<Department> departmentList = Arrays.asList(department1, department2);

        when(departmentRepo.findAll()).thenReturn(departmentList);

        // Act
        List<Department> result = departmentService.getAllDepartments();

        // Assert
        assertEquals(departmentList, result);
    }

    @Test
    void createDepartment() {
        // Arrange
        Department department = new Department("Mashine producement",
                "The creation or manufacture for sale of goods and services with exchange value", 42);

        when(departmentRepo.save(department)).thenReturn(department);

        // Act
        Department result = departmentService.createDepartment(department);

        // Assert
        assertEquals(department, result);
    }

    @Test
    void getDepartmentById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        Department department = new Department("Mashine producement",
                "The creation or manufacture for sale of goods and services with exchange value", 42);

        when(departmentRepo.findById(id)).thenReturn(Optional.of(department));

        // Act
        Department result = departmentService.getDepartmentById(id);

        // Assert
        assertEquals(department, result);
    }

    @Test
    void getDepartmentById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(departmentRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> departmentService.getDepartmentById(id));

        assertEquals("Department with id: " + id + " was not found.", exception.getMessage());
    }
}
