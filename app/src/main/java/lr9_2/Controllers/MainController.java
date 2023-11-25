package lr9_2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lr9_2.DTO.Card;
import lr9_2.DTO.Department;
import lr9_2.DTO.Employee;
import lr9_2.DTO.Mentoring;
import lr9_2.DTO.MonthlyExpectedWorkingHours;
import lr9_2.DTO.Position;
import lr9_2.DTO.Schedule;
import lr9_2.DTO.WorkedHours;
import lr9_2.Repositories.CardRepo;
import lr9_2.Repositories.DepartmentRepo;
import lr9_2.Repositories.EmployeeRepo;
import lr9_2.Repositories.ExpectedHoursRepo;
import lr9_2.Repositories.MentoringRepo;
import lr9_2.Repositories.PositionRepo;
import lr9_2.Repositories.ScheduleRepo;
import lr9_2.Repositories.WorkedHoursRepo;
import lr9_2.services.interfaces.EmployeeService;

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
