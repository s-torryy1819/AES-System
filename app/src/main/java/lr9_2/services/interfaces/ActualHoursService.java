package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.WorkedHours;

public interface ActualHoursService {

    List<WorkedHours> getAllActualHours();

    WorkedHours addActualHours(WorkedHours workedHours);

    void deleteActualHours(Integer id);

    WorkedHours getActualHoursById(Integer id) throws Exception;
}
