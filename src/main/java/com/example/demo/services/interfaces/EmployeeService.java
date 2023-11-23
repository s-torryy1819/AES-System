package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee getEmployeeById(Integer id) throws Exception;
} 
