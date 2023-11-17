package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "expected_hours")
public class MonthlyExpectedWorkingHours {

	private String Month;
	private Integer Hours;

	public MonthlyExpectedWorkingHours() {
	}

	public MonthlyExpectedWorkingHours(String month, Integer hours) {
		Month = month;
		Hours = hours;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String Month) {
		this.Month = Month;
	}

	public Integer getHours() {
		return Hours;
	}

	public void setHours(Integer Hours) {
		this.Hours = Hours;
	}

}