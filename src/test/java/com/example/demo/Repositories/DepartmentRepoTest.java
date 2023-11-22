package com.example.demo.Repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Models.Department;
import com.example.demo.Models.Employee;

@SpringBootTest
public class DepartmentRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;

    @Test
    public void GetDepartmentId_Department_CalledGetDepartmentIdToCheckDepartmentData() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        Department department = new Department("Mashine producement",
                "The creation or manufacture for sale of goods and services with exchange value", 42);
        employee.setDepartment(department);

        // Act
        employeeRepo.save(employee);
        departmentRepo.save(department);

        Integer expectedDepartmentId = employee.getDepartment().getDepartmentId();
        Integer actualDepartmentId = departmentRepo.findById(department.getDepartmentId()).get().getDepartmentId();

        // Assert
        assertEquals(expectedDepartmentId, actualDepartmentId);
    }
}