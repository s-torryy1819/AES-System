package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.Mentoring;
import lr9_2.Repositories.MentoringRepo;
import lr9_2.services.implementations.MentoringServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MentoringServiceTest {

    @Mock
    private MentoringRepo mentoringRepo;

    @InjectMocks
    private MentoringServiceImpl mentoringService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllMentoringObj() {
        // Arrange
        Mentoring mentoring1 = new Mentoring("Automotive Engineer", 12, 40, null, null);
        Mentoring mentoring2 = new Mentoring("Automotive Engineer", 12, 40, null, null);
        List<Mentoring> mentoringList = Arrays.asList(mentoring1, mentoring2);

        when(mentoringRepo.findAll()).thenReturn(mentoringList);

        // Act
        List<Mentoring> result = mentoringService.getAllMentoringObj();

        // Assert
        assertEquals(mentoringList, result);
    }

    @Test
    void createMentoringObj() {
        // Arrange
        Mentoring mentoring = new Mentoring("Automotive Engineer", 12, 40, null, null);

        when(mentoringRepo.save(mentoring)).thenReturn(mentoring);

        // Act
        Mentoring result = mentoringService.createMentoringObj(mentoring);

        // Assert
        assertEquals(mentoring, result);
    }

    @Test
    void getMentoringObjById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        Mentoring mentoring = new Mentoring("Automotive Engineer", 12, 40, null, null);

        when(mentoringRepo.findById(id)).thenReturn(Optional.of(mentoring));

        // Act
        Mentoring result = mentoringService.getMentoringObjById(id);

        // Assert
        assertEquals(mentoring, result);
    }

    @Test
    void getMentoringObjById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(mentoringRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> mentoringService.getMentoringObjById(id));

        assertEquals("Mentoring with id: " + id + " was not found.", exception.getMessage());
    }
}
