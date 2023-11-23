package com.example.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expectedHours")
public class MonthlyExpectedWorkingHours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer monthlyExpectedWorkingHourseId;

	private String month;
	private Integer hours;

	@OneToOne(mappedBy = "expectedWorkingHours")
	private Schedule schedule;

	public MonthlyExpectedWorkingHours() {
	}

	public MonthlyExpectedWorkingHours(String month, Integer hours, Schedule schedule) {
		this.month = month;
		this.hours = hours;
		this.schedule = schedule;
	}

	public void setMonthlyExpectedWorkingHourseId(Integer monthlyExpectedWorkingHourseId) {
		this.monthlyExpectedWorkingHourseId = monthlyExpectedWorkingHourseId;
	}

	public Integer getMonthlyExpectedWorkingHoursId() {
		return monthlyExpectedWorkingHourseId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}