package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Card;
import com.example.demo.DTO.Department;
import com.example.demo.DTO.Employee;
import com.example.demo.DTO.Mentoring;
import com.example.demo.DTO.MonthlyExpectedWorkingHours;
import com.example.demo.DTO.Position;
import com.example.demo.DTO.Schedule;
import com.example.demo.DTO.WorkedHours;
import com.example.demo.repositories.CardRepo;
import com.example.demo.repositories.DepartmentRepo;
import com.example.demo.repositories.EmployeeRepo;
import com.example.demo.repositories.ExpectedHoursRepo;
import com.example.demo.repositories.MentoringRepo;
import com.example.demo.repositories.PositionRepo;
import com.example.demo.repositories.ScheduleRepo;
import com.example.demo.repositories.WorkedHoursRepo;
import com.example.demo.services.interfaces.EmployeeService;

@RestController
public class MainController {

    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeService employeeService;
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

        Department department = new Department("Mashine producement",
                "The creation or manufacture for sale of goods and services with exchange value", 42);
        employee.setDepartment(department);
        department.setDirector(employee);
        employee.setDirectorOfDepartment(department);
        Position position = new Position("SEO");
        employee.setPosition(position);
        Card card = new Card(false, null);
        employee.setCard(card);

        Mentoring mentor = new Mentoring("Automotive Engineer", 12, 40, employee, null);
        employee.setMentor(mentor);

        Schedule schedule = new Schedule(null, null, employee);

        MonthlyExpectedWorkingHours mewh = new MonthlyExpectedWorkingHours("Apr", 42, schedule);
        schedule.setExpectedWorkingHours(mewh);
        WorkedHours workedHours = new WorkedHours(42, schedule);
        schedule.setActualWorkingHours(workedHours);

        employee.setScheduledList(schedule);

        employeeService.createEmployee(employee);
        // employeeRepo.save(employee);
        return "done";
    }

}
