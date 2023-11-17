package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mentor")
public class Mentor {

	private Employee Person;
	private String Specialisation;
	private Integer Num_of_months;
	private Integer Hours_of_work;

	public Mentor() {
	}

	public Mentor(Employee person, String specialisation, Integer num_of_months, Integer hours_of_work) {
		Person = person;
		Specialisation = specialisation;
		Num_of_months = num_of_months;
		Hours_of_work = hours_of_work;
	}

	public Employee getPerson() {
		return Person;
	}

	public void setPerson(Employee person) {
		Person = person;
	}

	public String getSpecialisation() {
		return Specialisation;
	}

	public void setSpecialisation(String Specialisation) {
		this.Specialisation = Specialisation;
	}

	public Integer getNum_of_months() {
		return Num_of_months;
	}

	public void setNum_of_months(Integer Num_of_months) {
		this.Num_of_months = Num_of_months;
	}

	public Integer getHours_of_work() {
		return Hours_of_work;
	}

	public void setHours_of_work(Integer Hours_of_work) {
		this.Hours_of_work = Hours_of_work;
	}

}