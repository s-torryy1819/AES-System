package lr9_2.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import lr9_2.DTO.Mentoring;
import lr9_2.Repositories.MentoringRepo;
import lr9_2.services.interfaces.MentoringService;
import org.springframework.stereotype.Service;

@Service
public class MentoringServiceImpl implements MentoringService {

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

        if (!mOptional.isPresent()) {
            throw new NoSuchElementException("Mentoring with id: " + id + " was not found.");
        }

        return mOptional.get();
    }

}
