package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expected_hours")
public class MonthlyExpectedWorkingHours {

	@Id
	private Integer monthlyExpectedWorkingHourseId;

	private String month;
	private Integer hours;

	@OneToOne(mappedBy = "expected_working_hours")
	private Schedule schedule;

	public MonthlyExpectedWorkingHours() {
	}

}