package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

	private MonthlyExpectedWorkingHours Expected_working_hours;
	private WorkedHours Actual_working_hours;

	public Schedule() {
	}

	public Schedule(MonthlyExpectedWorkingHours expected_working_hours, WorkedHours actual_working_hours) {
		Expected_working_hours = expected_working_hours;
		Actual_working_hours = actual_working_hours;
	}

	public MonthlyExpectedWorkingHours getExpected_working_hours() {
		return Expected_working_hours;
	}

	public void setExpected_working_hours(MonthlyExpectedWorkingHours expected_working_hours) {
		Expected_working_hours = expected_working_hours;
	}

	public WorkedHours getActual_working_hours() {
		return Actual_working_hours;
	}

	public void setActual_working_hours(WorkedHours actual_working_hours) {
		Actual_working_hours = actual_working_hours;
	}

}