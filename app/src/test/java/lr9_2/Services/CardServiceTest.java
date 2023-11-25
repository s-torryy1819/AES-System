package lr9_2.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lr9_2.DTO.Card;
import lr9_2.Repositories.CardRepo;
import lr9_2.services.implementations.CardServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CardServiceTest {

    @Mock
    private CardRepo cardRepo;

    @InjectMocks
    private CardServiceImpl cardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCards() {
        // Arrange
        Card card1 = new Card(true, null);
        Card card2 = new Card(true, null);
        List<Card> cardList = Arrays.asList(card1, card2);

        when(cardRepo.findAll()).thenReturn(cardList);

        // Act
        List<Card> result = cardService.getAllCards();

        // Assert
        assertEquals(cardList, result);
    }

    @Test
    void createCard() {
        // Arrange
        Card card = new Card(true, null);

        when(cardRepo.save(card)).thenReturn(card);

        // Act
        Card result = cardService.createCard(card);

        // Assert
        assertEquals(card, result);
    }

    @Test
    void deleteCard_existingId() {
        // Arrange
        Integer id = 1;
        Card card = new Card(true, null);

        when(cardRepo.findById(id)).thenReturn(Optional.of(card));

        // Act
        assertDoesNotThrow(() -> cardService.deleteCard(id));

        // Assert
        verify(cardRepo, times(1)).delete(card);
    }

    @Test
    void deleteCard_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(cardRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> cardService.deleteCard(id));

        assertEquals("Card with id: " + id + " was not found.", exception.getMessage());
    }

    @Test
    void getCardById_existingId() throws Exception {
        // Arrange
        Integer id = 1;
        Card card = new Card(true, null);

        when(cardRepo.findById(id)).thenReturn(Optional.of(card));

        // Act
        Card result = cardService.getCardById(id);

        // Assert
        assertEquals(card, result);
    }

    @Test
    void getCardById_nonExistingId() {
        // Arrange
        Integer id = 1;

        when(cardRepo.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class,
                () -> cardService.getCardById(id));

        assertEquals("Card with id: " + id + " was not found.", exception.getMessage());
    }
}
