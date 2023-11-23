package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTO.Employee;
import com.example.demo.DTO.Mentoring;

@SpringBootTest
public class MentoringRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private MentoringRepo mentoringRepo;

    @Test
    public void GetMentorId_Position_CalledGetPositionIdToCheckMentoringData() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        Mentoring mentor = new Mentoring("Automotive Engineer", 12, 40, employee, null);
        employee.setMentor(mentor);

        // Act
        employeeRepo.save(employee);
        mentoringRepo.save(mentor);

        Integer expectedMentorId = employee.getMentor().getMentoringId();
        Integer actualMentorId = mentoringRepo.findById(mentor.getMentoringId()).get().getMentoringId();

        // Assert
        assertEquals(expectedMentorId, actualMentorId);
    }
}