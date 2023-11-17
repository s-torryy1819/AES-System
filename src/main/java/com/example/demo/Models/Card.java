package com.example.demo.Models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

	private Integer Employee_Id;
	private Boolean Blocked;
	private Date Expiration_date;
	private Integer Card_Id;

	public Card() {
	}

	public Card(Integer employee_Id, Boolean blocked, Date expiration_date, Integer card_Id) {
		this.Employee_Id = employee_Id;
		this.Blocked = blocked;
		this.Expiration_date = expiration_date;
		this.Card_Id = card_Id;
	}

	public Integer getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(Integer employee_Id) {
		Employee_Id = employee_Id;
	}

	public Integer getCard_Id() {
		return Card_Id;
	}

	public void setCard_Id(Integer Card_Id) {
		this.Card_Id = Card_Id;
	}

	public Boolean isBlocked() {
		return Blocked;
	}

	public void setBlocked(Boolean Blocked) {
		this.Blocked = Blocked;
	}

	public Date getExpiration_date() {
		return Expiration_date;
	}

	public void setExpiration_date(Date Expiration_date) {
		this.Expiration_date = Expiration_date;
	}

}