package com.example.demo.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	private Integer scheduleId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "monthlyExpectedWorkingHourse_Id", referencedColumnName = "monthlyExpectedWorkingHourseId")
	private MonthlyExpectedWorkingHours expected_working_hours;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "workedHours_Id", referencedColumnName = "workedHoursId")
	private WorkedHours actual_working_hours;

	public Schedule() {
	}

}