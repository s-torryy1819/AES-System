package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee getEmployeeById(Integer id) throws Exception;
}
