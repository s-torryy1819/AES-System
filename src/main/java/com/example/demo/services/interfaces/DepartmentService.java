package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.Department;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department createDepartment(Department department);

    Department getDepartmentById(Integer id) throws Exception;
} 
