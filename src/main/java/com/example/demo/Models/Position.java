package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "position")
public class Position {

	private Integer Id;
	private String Description;

	public Position() {
	}

	public Integer getId() {
		return Id;
	}

	public Position(Integer id, String description) {
		Id = id;
		Description = description;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

}