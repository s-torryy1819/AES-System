
package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	private Integer Id;
	private String Name;
	private Employee Director;
	private String Description;
	private Integer Num_of_employees;

	public Department() {
	}

	public Department(Integer Id, String Name, Employee Director, String Description, Integer Num_of_employees) {
		this.Id = Id;
		this.Name = Name;
		this.Director = Director;
		this.Description = Description;
		this.Num_of_employees = Num_of_employees;
	}

	public Integer getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public Employee getDirector() {
		return Director;
	}

	public String getDescription() {
		return Description;
	}

	public Integer getNumOfEmployees() {
		return Num_of_employees;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setDirector(Employee Director) {
		this.Director = Director;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public Integer getNum_of_employees() {
		return Num_of_employees;
	}

	public void setNum_of_employees(Integer Num_of_employees) {
		this.Num_of_employees = Num_of_employees;
	}

}