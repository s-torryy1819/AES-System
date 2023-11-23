package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.MonthlyExpectedWorkingHours;

public interface ExpectedHoursService {
    
    List<MonthlyExpectedWorkingHours> getAllExpectedHours();

    MonthlyExpectedWorkingHours createExpectedHours(MonthlyExpectedWorkingHours monthlyExpectedWorkingHours);

    MonthlyExpectedWorkingHours getExpectedHoursById(Integer id) throws Exception;
}
