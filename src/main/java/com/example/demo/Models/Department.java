
package com.example.demo.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;
	private String name;
	// private Employee Director;
	private String description;
	private Integer numOfEmployees;

	@OneToMany(mappedBy = "department")
	private List<Employee> employees = new ArrayList<>();

	public Department() {
	}

	public Department(String name, String description, Integer numOfEmployees) {
		this.name = name;
		this.description = description;
		this.numOfEmployees = numOfEmployees;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(Integer numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}