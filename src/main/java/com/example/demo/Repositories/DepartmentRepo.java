package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.DTO.Department;

@EnableJpaRepositories
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}