package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.MonthlyExpectedWorkingHours;

public interface ExpectedHoursService {

    List<MonthlyExpectedWorkingHours> getAllExpectedHours();

    MonthlyExpectedWorkingHours createExpectedHours(MonthlyExpectedWorkingHours monthlyExpectedWorkingHours);

    MonthlyExpectedWorkingHours getExpectedHoursById(Integer id) throws Exception;
}
