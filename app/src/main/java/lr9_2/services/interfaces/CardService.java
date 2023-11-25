package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.Card;

public interface CardService {

    List<Card> getAllCards();

    Card createCard(Card card);

    void deleteCard(Integer id);

    Card getCardById(Integer id) throws Exception;
}
