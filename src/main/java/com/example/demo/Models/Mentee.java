package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mentee")
public class Mentee {

	private Employee Person;
	private String Specialisation;
	private Integer Working_hours;

	public Mentee() {
	}

	public Mentee(Employee person, String specialisation, Integer working_hours) {
		Person = person;
		Specialisation = specialisation;
		Working_hours = working_hours;
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

	public Integer getWorking_hours() {
		return Working_hours;
	}

	public void setWorking_hours(Integer Working_hours) {
		this.Working_hours = Working_hours;
	}

}