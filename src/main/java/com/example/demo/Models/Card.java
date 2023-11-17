package com.example.demo.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

	@Id
	private Integer card_Id;
	private Boolean blocked;
	private LocalDate expiration_date;

	@OneToOne(mappedBy = "card")
	private Employee employee;

	public Card() {
	}

}