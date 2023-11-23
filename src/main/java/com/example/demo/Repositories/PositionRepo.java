package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.DTO.Position;

@EnableJpaRepositories
public interface PositionRepo extends JpaRepository<Position, Integer> {

}