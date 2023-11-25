package lr9_2.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import lr9_2.DTO.Schedule;
import lr9_2.Repositories.ScheduleRepo;
import lr9_2.services.interfaces.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepo scheduleRepo;

    public ScheduleServiceImpl(ScheduleRepo scheduleRepo) {
        super();
        this.scheduleRepo = scheduleRepo;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepo.findAll();
    }

    @Override
    public Schedule createSchedule(Schedule card) {
        return scheduleRepo.save(card);
    }

    @Override
    public void deleteSchedule(Integer id) {
        Optional<Schedule> card = scheduleRepo.findById(id);

        if (card.isPresent()) {
            scheduleRepo.delete(card.get());
        } else {
            throw new NoSuchElementException("Card with id: " + id + " was not found.");
        }
    }

    @Override
    public Schedule getScheduleById(Integer id) throws Exception {
        Optional<Schedule> card = scheduleRepo.findById(id);

        if (!card.isPresent()) {
            throw new NoSuchElementException("Card with id: " + id + " was not found.");
        }

        return card.get();
    }

}
