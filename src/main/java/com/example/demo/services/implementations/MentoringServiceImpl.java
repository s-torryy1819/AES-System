package com.example.demo.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.DTO.Mentoring;
import com.example.demo.repositories.MentoringRepo;
import com.example.demo.services.interfaces.MentoringService;

public class MentoringServiceImpl implements MentoringService{

    private final MentoringRepo mentoringRepo;

    public MentoringServiceImpl(MentoringRepo mentoringRepo) {
		super();
		this.mentoringRepo = mentoringRepo;
	}

    @Override
    public List<Mentoring> getAllMentoringObj() {
        return mentoringRepo.findAll();
    }

    @Override
    public Mentoring createMentoringObj(Mentoring mentoring) {
        return mentoringRepo.save(mentoring);
    }

    @Override
    public Mentoring getMentoringObjById(Integer id) throws Exception {
        Optional<Mentoring> mOptional = mentoringRepo.findById(id);

        if(!mOptional.isPresent()) {
			throw new NoSuchElementException("Mentoring with id: " + id + " was not found.");
		}

		return mOptional.get();
    }
    
}
