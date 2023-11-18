package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Models.Schedule;

@EnableJpaRepositories
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {

}