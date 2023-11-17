package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "worked_hours")
public class WorkedHours {

	private Integer Employee_Id;
	private Integer Num_of_hours;

	public WorkedHours() {
	}

	public WorkedHours(Integer employee_Id, Integer num_of_hours) {
		Employee_Id = employee_Id;
		Num_of_hours = num_of_hours;
	}

	public Integer getEmployee_Id() {
		return Employee_Id;
	}

	public Integer getNum_of_hours() {
		return Num_of_hours;
	}

	public void setNum_of_hours(Integer num_of_hours) {
		Num_of_hours = num_of_hours;
	}

}