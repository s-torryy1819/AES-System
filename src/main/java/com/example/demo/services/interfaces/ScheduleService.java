package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.Schedule;

public interface ScheduleService {
    List<Schedule> getAllSchedules();

    Schedule createSchedule(Schedule schedule);

    void deleteSchedule(Integer id);

    Schedule getScheduleById(Integer id) throws Exception;
}
