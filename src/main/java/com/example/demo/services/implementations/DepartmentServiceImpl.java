package com.example.demo.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.DTO.Department;
import com.example.demo.repositories.DepartmentRepo;
import com.example.demo.services.interfaces.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
		super();
		this.departmentRepo = departmentRepo;
	}

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department createDepartment(Department card) {
        return departmentRepo.save(card);
    }

    @Override
    public Department getDepartmentById(Integer id) throws Exception {
        Optional<Department> card = departmentRepo.findById(id);

        if(!card.isPresent()) {
			throw new NoSuchElementException("Department with id: " + id + " was not found.");
		}

		return card.get();
    }
}
