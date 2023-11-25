package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.Position;

public interface PositionService {

    List<Position> getAllPositions();

    Position createPosition(Position position);

    void deletePosition(Integer id);

    Position getPositionById(Integer id) throws Exception;
}
