package lr9_2.Repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lr9_2.DTO.Employee;

@SpringBootTest
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo repository;

    @Test
    public void FindById_EmployeeId_CalledFindMethodToCheckIfEmpoyeeWasSaved() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        repository.save(employee);

        Integer expectedId = employee.getEmployeeId();

        // Act
        Integer actualId = repository.findById(employee.getEmployeeId()).get().getEmployeeId();

        repository.delete(employee);

        // Assert
        assertEquals(expectedId, actualId);
    }
}