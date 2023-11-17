package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	private Integer Id;
	private String Name;
	private String Surname;
	private String Department;
	private Mentor My_Mentor;
	private Mentee My_Mentee;
	private String Position;
	private Integer Card_Id;
	private Schedule Scheduled_list;
	private WorkedHours Worked_Hours;

	public Employee() {
	}

	public Employee(Integer id, String name, String surname, String department, Mentor my_Mentor, Mentee my_Mentee,
			String position, Integer card_Id, Schedule scheduled_list, WorkedHours worked_Hours) {
		this.Id = id;
		this.Name = name;
		this.Surname = surname;
		this.Department = department;
		this.My_Mentor = my_Mentor;
		this.My_Mentee = my_Mentee;
		this.Position = position;
		this.Card_Id = card_Id;
		this.Scheduled_list = scheduled_list;
		this.Worked_Hours = worked_Hours;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public Mentor getMy_Mentor() {
		return My_Mentor;
	}

	public void setMy_Mentor(Mentor my_Mentor) {
		My_Mentor = my_Mentor;
	}

	public Mentee getMy_Mentee() {
		return My_Mentee;
	}

	public void setMy_Mentee(Mentee my_Mentee) {
		My_Mentee = my_Mentee;
	}

	public WorkedHours getWorked_Hours() {
		return Worked_Hours;
	}

	public void setWorked_Hours(WorkedHours worked_Hours) {
		Worked_Hours = worked_Hours;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String Surname) {
		this.Surname = Surname;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String Position) {
		this.Position = Position;
	}

	public Integer getCard_Id() {
		return Card_Id;
	}

	public void setCard_Id(Integer Card_Id) {
		this.Card_Id = Card_Id;
	}

	public Schedule getScheduled_list() {
		return Scheduled_list;
	}

	public void setScheduled_list(Schedule Scheduled_list) {
		this.Scheduled_list = Scheduled_list;
	}

}