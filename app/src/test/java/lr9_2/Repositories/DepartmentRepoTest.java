package lr9_2.Repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lr9_2.DTO.Department;
import lr9_2.DTO.Employee;

@SpringBootTest
public class DepartmentRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;

    @Test
    public void FindDepartmentById_Department_CalledGetDepartmentIdToCheckDepartmentData() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        Department department = new Department("Mashine producement",
                "The creation or manufacture for sale of goods and services with exchange value", 42);
        employee.setDepartment(department);

        employeeRepo.save(employee);
        departmentRepo.save(department);

        Integer expectedDepartmentId = employee.getDepartment().getDepartmentId();

        // Act
        Integer actualDepartmentId = departmentRepo.findById(department.getDepartmentId()).get().getDepartmentId();

        employeeRepo.delete(employee);
        departmentRepo.delete(department);

        // Assert
        assertEquals(expectedDepartmentId, actualDepartmentId);
    }
}