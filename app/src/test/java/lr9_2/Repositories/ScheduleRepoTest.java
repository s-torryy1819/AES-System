package lr9_2.Repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lr9_2.DTO.Employee;
import lr9_2.DTO.MonthlyExpectedWorkingHours;
import lr9_2.DTO.Schedule;
import lr9_2.DTO.WorkedHours;

@SpringBootTest
public class ScheduleRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ExpectedHoursRepo expectedHoursRepo;
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private WorkedHoursRepo workedHoursRepo;

    @Test
    public void FindHours_Schedule_CalledGetHoursToCheckScheduleData() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        MonthlyExpectedWorkingHours expectedHours = new MonthlyExpectedWorkingHours("Jan", 160, null);
        WorkedHours workedHours = new WorkedHours(160, null);
        Schedule schedule = new Schedule(expectedHours, workedHours, employee);

        workedHours.setSchedule(schedule);
        expectedHours.setSchedule(schedule);
        employee.setScheduledList(schedule);

        Integer expectedWorkingHours = schedule.getExpectedWorkingHours().getHours();

        employeeRepo.save(employee);
        scheduleRepo.save(schedule);
        expectedHoursRepo.save(expectedHours);
        workedHoursRepo.save(workedHours);

        // Act

        Integer actualHours = scheduleRepo.findById(schedule.getScheduleId()).get().getExpectedWorkingHours()
                .getHours();

        employeeRepo.delete(employee);
        scheduleRepo.delete(schedule);
        expectedHoursRepo.delete(expectedHours);
        workedHoursRepo.delete(workedHours);

        // Assert
        assertEquals(expectedWorkingHours, actualHours);
    }
}