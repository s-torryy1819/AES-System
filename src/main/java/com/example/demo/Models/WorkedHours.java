package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "worked_hours")
public class WorkedHours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer workedHoursId;
	private Integer numOfHours;

	@OneToOne(mappedBy = "actualWorkingHours")
	private Schedule schedule;

	public WorkedHours() {
	}

	public WorkedHours(Integer numOfHours, Schedule schedule) {
		this.numOfHours = numOfHours;
		this.schedule = schedule;
	}

	public Integer getWorkedHoursId() {
		return workedHoursId;
	}

	public void setWorkedHoursId(Integer workedHoursId) {
		this.workedHoursId = workedHoursId;
	}

	public Integer getNumOfHours() {
		return numOfHours;
	}

	public void setNumOfHours(Integer numOfHours) {
		this.numOfHours = numOfHours;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}