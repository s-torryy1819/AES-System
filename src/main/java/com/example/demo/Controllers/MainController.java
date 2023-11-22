package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Card;
import com.example.demo.Models.Department;
import com.example.demo.Models.Employee;
import com.example.demo.Models.Mentoring;
import com.example.demo.Models.MonthlyExpectedWorkingHours;
import com.example.demo.Models.Position;
import com.example.demo.Models.Schedule;
import com.example.demo.Models.WorkedHours;
import com.example.demo.Repositories.CardRepo;
import com.example.demo.Repositories.DepartmentRepo;
import com.example.demo.Repositories.EmployeeRepo;
import com.example.demo.Repositories.ExpectedHoursRepo;
import com.example.demo.Repositories.MentoringRepo;
import com.example.demo.Repositories.PositionRepo;
import com.example.demo.Repositories.ScheduleRepo;
import com.example.demo.Repositories.WorkedHoursRepo;

@RestController
public class MainController {

    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ExpectedHoursRepo expectedHoursRepo;
    @Autowired
    private MentoringRepo mentoringRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private WorkedHoursRepo workedHoursRepo;

    @GetMapping("/setUpData")
    public String setUpData() {

        Employee employee = new Employee("Mr Egon", "Sachse", null, null, null, null, null, null);

        Department department = new Department("Egons department", "Is just perfect here :)", 42);
        employee.setDepartment(department);
        department.setDirector(employee);
        employee.setDirectorOfDepartment(department);
        Position position = new Position("Big boss");
        employee.setPosition(position);
        Card card = new Card(false, null);
        employee.setCard(card);

        Mentoring mentor = new Mentoring("Sleeping", 12, 40, employee, null);
        employee.setMentor(mentor);

        Schedule schedule = new Schedule(null, null, employee);

        MonthlyExpectedWorkingHours mewh = new MonthlyExpectedWorkingHours("Apr", 42, schedule);
        schedule.setExpectedWorkingHours(mewh);
        WorkedHours workedHours = new WorkedHours(42, schedule);
        schedule.setActualWorkingHours(workedHours);

        employee.setScheduledList(schedule);

        employeeRepo.save(employee);
        return "done";
    }

}
