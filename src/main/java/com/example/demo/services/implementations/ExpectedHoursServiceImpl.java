package com.example.demo.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.DTO.MonthlyExpectedWorkingHours;
import com.example.demo.repositories.ExpectedHoursRepo;
import com.example.demo.services.interfaces.ExpectedHoursService;

public class ExpectedHoursServiceImpl implements ExpectedHoursService{

    private final ExpectedHoursRepo expectedHoursRepo;

    public ExpectedHoursServiceImpl(ExpectedHoursRepo expectedHoursRepo) {
		super();
		this.expectedHoursRepo = expectedHoursRepo;
	}

    @Override
    public List<MonthlyExpectedWorkingHours> getAllExpectedHours() {
        return expectedHoursRepo.findAll();
    }

    @Override
    public MonthlyExpectedWorkingHours createExpectedHours(MonthlyExpectedWorkingHours expectedWorkingHours) {
        return expectedHoursRepo.save(expectedWorkingHours);
    }

    @Override
    public MonthlyExpectedWorkingHours getExpectedHoursById(Integer id) throws Exception {
        Optional<MonthlyExpectedWorkingHours> eOptional = expectedHoursRepo.findById(id);

        if(!eOptional.isPresent()) {
			throw new NoSuchElementException("Monthly Expected Working Hours with id: " + id + " was not found.");
		}

		return eOptional.get();
    }
    
}
