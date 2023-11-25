package lr9_2.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import lr9_2.DTO.Position;
import lr9_2.Repositories.PositionRepo;
import lr9_2.services.interfaces.PositionService;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepo positionRepo;

    public PositionServiceImpl(PositionRepo positionRepo) {
        super();
        this.positionRepo = positionRepo;
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepo.findAll();
    }

    @Override
    public Position createPosition(Position position) {
        return positionRepo.save(position);
    }

    @Override
    public void deletePosition(Integer id) {
        Optional<Position> pOptional = positionRepo.findById(id);

        if (pOptional.isPresent()) {
            positionRepo.delete(pOptional.get());
        } else {
            throw new NoSuchElementException("Position with id: " + id + " was not found.");
        }
    }

    @Override
    public Position getPositionById(Integer id) throws Exception {
        Optional<Position> pOptional = positionRepo.findById(id);

        if (!pOptional.isPresent()) {
            throw new NoSuchElementException("Position with id: " + id + " was not found.");
        }

        return pOptional.get();
    }

}
