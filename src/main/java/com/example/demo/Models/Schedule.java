package com.example.demo.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer scheduleId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "monthlyExpectedWorkingHourseId", referencedColumnName = "monthlyExpectedWorkingHourseId")
	private MonthlyExpectedWorkingHours expectedWorkingHours;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "workedHoursId", referencedColumnName = "workedHoursId")
	private WorkedHours actualWorkingHours;

	@OneToOne(mappedBy = "scheduledList")
	private Employee employee;

	public Schedule() {
	}

	public Schedule(MonthlyExpectedWorkingHours expectedWorkingHours, WorkedHours actualWorkingHours,
			Employee employee) {
		this.expectedWorkingHours = expectedWorkingHours;
		this.actualWorkingHours = actualWorkingHours;
		this.employee = employee;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public MonthlyExpectedWorkingHours getExpectedWorkingHours() {
		return expectedWorkingHours;
	}

	public void setExpectedWorkingHours(MonthlyExpectedWorkingHours expectedWorkingHours) {
		this.expectedWorkingHours = expectedWorkingHours;
	}

	public WorkedHours getActualWorkingHours() {
		return actualWorkingHours;
	}

	public void setActualWorkingHours(WorkedHours actualWorkingHours) {
		this.actualWorkingHours = actualWorkingHours;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}