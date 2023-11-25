package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.Position;
import lr9_2.Repositories.PositionRepo;
import lr9_2.services.implementations.PositionServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PositionServiceTest {

    @Mock
    private PositionRepo positionRepo;

    @InjectMocks
    private PositionServiceImpl positionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPositions() {
        // Arrange
        Position position1 = new Position("STO");
        Position position2 = new Position("STO");
        List<Position> positionList = Arrays.asList(position1, position2);

        when(positionRepo.findAll()).thenReturn(positionList);

        // Act
        List<Position> result = positionService.getAllPositions();

        // Assert
        assertEquals(positionList, result);
    }

    @Test
    void createPosition() {
        // Arrange
        Position position = new Position("STO");

        when(positionRepo.save(position)).thenReturn(position);

        // Act
        Position result = positionService.createPosition(position);

        // Assert
        assertEquals(position, result);
    }

    @Test
    void deletePosition_existingId() {
        // Arrange
        Integer id = 1;
        Position position = new Position("STO");

        when(positionRepo.findById(id)).thenReturn(Optional.of(position));

        // Act
        assertDoesNotThrow(() -> positionService.deletePosition(id));

        // Assert
        verify(positionRepo, times(1)).delete(position);
    }

    @Test
    void deletePosition_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(positionRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> positionService.deletePosition(id));

        assertEquals("Position with id: " + id + " was not found.", exception.getMessage());
    }

    @Test
    void getPositionById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        Position position = new Position("STO");

        when(positionRepo.findById(id)).thenReturn(Optional.of(position));

        // Act
        Position result = positionService.getPositionById(id);

        // Assert
        assertEquals(position, result);
    }

    @Test
    void getPositionById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(positionRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> positionService.getPositionById(id));

        assertEquals("Position with id: " + id + " was not found.", exception.getMessage());
    }
}
