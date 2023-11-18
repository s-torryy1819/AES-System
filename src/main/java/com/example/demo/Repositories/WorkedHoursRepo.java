package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Models.WorkedHours;

@EnableJpaRepositories
public interface WorkedHoursRepo extends JpaRepository<WorkedHours, Integer> {

}