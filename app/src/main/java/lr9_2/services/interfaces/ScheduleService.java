package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.Schedule;

public interface ScheduleService {
    List<Schedule> getAllSchedules();

    Schedule createSchedule(Schedule schedule);

    void deleteSchedule(Integer id);

    Schedule getScheduleById(Integer id) throws Exception;
}
