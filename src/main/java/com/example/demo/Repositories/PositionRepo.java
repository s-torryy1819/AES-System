package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Models.Position;

@EnableJpaRepositories
public interface PositionRepo extends JpaRepository<Position, Integer> {

}