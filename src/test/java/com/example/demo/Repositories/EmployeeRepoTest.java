package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTO.Employee;
import com.example.demo.repositories.EmployeeRepo;

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

        // Assert
        assertEquals(expectedId, actualId);
    }
}