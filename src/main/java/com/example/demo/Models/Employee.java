package com.example.demo.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;

	private String name;
	private String surname;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "position_id")
	private Position position;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card_id", referencedColumnName = "cardId")
	private Card card;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mentoring_mentor_id", referencedColumnName = "mentoringId")
	private Mentoring mentor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mentoring_mentee_id", referencedColumnName = "mentoringId")
	private Mentoring mentee;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_id", referencedColumnName = "scheduleId")
	private Schedule scheduledList;

	public Employee() {
	}

	public Employee(String name, String surname, Department department, Position position,
			Card card, Mentoring mentor, Mentoring mentee, Schedule scheduledList) {
		this.name = name;
		this.surname = surname;
		this.department = department;
		this.position = position;
		this.card = card;
		this.mentor = mentor;
		this.mentee = mentee;
		this.scheduledList = scheduledList;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Mentoring getMentor() {
		return mentor;
	}

	public void setMentor(Mentoring mentor) {
		this.mentor = mentor;
	}

	public Mentoring getMentee() {
		return mentee;
	}

	public void setMentee(Mentoring mentee) {
		this.mentee = mentee;
	}

	public Schedule getScheduledList() {
		return scheduledList;
	}

	public void setScheduledList(Schedule scheduledList) {
		this.scheduledList = scheduledList;
	}

}