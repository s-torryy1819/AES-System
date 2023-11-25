package lr9_2.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lr9_2.DTO.WorkedHours;
import lr9_2.Repositories.WorkedHoursRepo;
import lr9_2.services.interfaces.ActualHoursService;

@Service
public class ActualHoursServiceImpl implements ActualHoursService {

    private final WorkedHoursRepo workedHoursRepo;

    public ActualHoursServiceImpl(WorkedHoursRepo workedHoursRepo) {
        super();
        this.workedHoursRepo = workedHoursRepo;
    }

    @Override
    public List<WorkedHours> getAllActualHours() {
        return workedHoursRepo.findAll();
    }

    @Override
    public WorkedHours addActualHours(WorkedHours workedHours) {
        return workedHoursRepo.save(workedHours);
    }

    @Override
    public void deleteActualHours(Integer id) {
        Optional<WorkedHours> wOptional = workedHoursRepo.findById(id);

        if (wOptional.isPresent()) {
            workedHoursRepo.delete(wOptional.get());
        } else {
            throw new NoSuchElementException("WorkedHours with id: " + id + " was not found.");
        }
    }

    @Override
    public WorkedHours getActualHoursById(Integer id) throws Exception {
        Optional<WorkedHours> wOptional = workedHoursRepo.findById(id);

        if (!wOptional.isPresent()) {
            throw new NoSuchElementException("WorkedHours with id: " + id + " was not found.");
        }

        return wOptional.get();
    }

}
