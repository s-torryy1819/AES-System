package com.example.demo.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "position")
public class Position {

	@Id
	private Integer positionId;
	private String description;

	@OneToMany(mappedBy = "position")
	private List<Employee> employees = new ArrayList<>();

	public Position() {
	}

}