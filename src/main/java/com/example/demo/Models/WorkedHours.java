package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "worked_hours")
public class WorkedHours {

	@Id
	private Integer workedHoursId;
	private Integer num_of_hours;

	@OneToOne(mappedBy = "actual_working_hours")
	private Schedule schedule;

	public WorkedHours() {
	}

}