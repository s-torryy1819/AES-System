package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.DTO.Card;

@EnableJpaRepositories
public interface CardRepo extends JpaRepository<Card, Integer> {

}