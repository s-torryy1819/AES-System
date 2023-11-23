package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.DTO.Schedule;

@EnableJpaRepositories
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {

}