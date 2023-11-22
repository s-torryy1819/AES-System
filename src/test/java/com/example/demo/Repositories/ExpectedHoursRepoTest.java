package com.example.demo.Repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Models.Employee;
import com.example.demo.Models.MonthlyExpectedWorkingHours;
import com.example.demo.Models.Schedule;
import com.example.demo.Models.WorkedHours;

@SpringBootTest
public class ExpectedHoursRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ExpectedHoursRepo expectedHoursRepo;
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private WorkedHoursRepo workedHoursRepo;

    @Test
    public void GetHoursId_ExpectedWorkedHours_CalledGetWorkedHoursIdToCheckSavingObject() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        MonthlyExpectedWorkingHours expectedHours = new MonthlyExpectedWorkingHours("Jan", 160, null);
        WorkedHours workedHours = new WorkedHours(160, null);
        Schedule schedule = new Schedule(expectedHours, workedHours, employee);

        workedHours.setSchedule(schedule);
        expectedHours.setSchedule(schedule);

        // Act
        employeeRepo.save(employee);
        scheduleRepo.save(schedule);
        expectedHoursRepo.save(expectedHours);
        workedHoursRepo.save(workedHours);

        Integer expectedHoursId = expectedHours.getMonthlyExpectedWorkingHoursId();
        Integer actualHoursId = expectedHoursRepo
                .findById(schedule.getExpectedWorkingHours().getMonthlyExpectedWorkingHoursId()).get()
                .getMonthlyExpectedWorkingHoursId();

        // Assert
        assertEquals(expectedHoursId, actualHoursId);
    }
}