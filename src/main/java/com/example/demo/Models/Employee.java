package com.example.demo.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	private Integer employeeId;

	private String name;
	private String surname;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId")
	private Department department;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "positionId")
	private Position position;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card_Id", referencedColumnName = "card_Id")
	private Card card;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mentor_Id", referencedColumnName = "mentoringId")
	private Mentoring mentor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mentee_Id", referencedColumnName = "mentoringId")
	private Mentoring mentee;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_Id", referencedColumnName = "scheduleId")
	private Schedule Scheduled_list;

	public Employee() {
	}

}