package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.Mentoring;

public interface MentoringService {
    
    List<Mentoring> getAllMentoringObj();

    Mentoring createMentoringObj(Mentoring mentoring);

    Mentoring getMentoringObjById(Integer id) throws Exception;
}
