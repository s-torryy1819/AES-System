package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.Position;

public interface PositionService {
    
    List<Position> getAllPositions();

    Position createPosition(Position position);

    void deletePosition(Integer id);

    Position getPositionById(Integer id) throws Exception;
}
