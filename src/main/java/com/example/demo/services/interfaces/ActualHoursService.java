package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.WorkedHours;

public interface ActualHoursService {

    List<WorkedHours> getAllActualHours();

    WorkedHours addActualHours(WorkedHours workedHours);

    void deleteActualHours(Integer id);

    WorkedHours getActualHoursById(Integer id) throws Exception;
}
