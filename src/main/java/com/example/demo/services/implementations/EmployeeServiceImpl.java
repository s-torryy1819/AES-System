package com.example.demo.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.DTO.Employee;
import com.example.demo.repositories.EmployeeRepo;
import com.example.demo.services.interfaces.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Optional<Employee> eOptional = employeeRepo.findById(id);

        if(eOptional.isPresent()) {
			employeeRepo.delete(eOptional.get());
		}else {
			throw new NoSuchElementException("Employee with id: " + id + " was not found.");
		}
    }

    @Override
    public Employee getEmployeeById(Integer id) throws Exception {
        Optional<Employee> eOptional = employeeRepo.findById(id);

        if(!eOptional.isPresent()) {
			throw new NoSuchElementException("Employee with id: " + id + " was not found.");
		}

		return eOptional.get();
    }
    
}
