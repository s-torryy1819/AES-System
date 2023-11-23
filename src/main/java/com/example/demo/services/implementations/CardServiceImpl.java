package com.example.demo.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.DTO.Card;
import com.example.demo.repositories.CardRepo;
import com.example.demo.services.interfaces.CardService;

public class CardServiceImpl implements CardService{

    private final CardRepo cardRepo;

    public CardServiceImpl(CardRepo cardRepo) {
		super();
		this.cardRepo = cardRepo;
	}

    @Override
    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }

    @Override
    public Card createCard(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public void deleteCard(Integer id) {
        Optional<Card> card = cardRepo.findById(id);

        if(card.isPresent()) {
			cardRepo.delete(card.get());
		}else {
			throw new NoSuchElementException("Card with id: " + id + " was not found.");
		}
    }

    @Override
    public Card getCardById(Integer id) throws Exception {
        Optional<Card> card = cardRepo.findById(id);

        if(!card.isPresent()) {
			throw new NoSuchElementException("Card with id: " + id + " was not found.");
		}

		return card.get();
    }
    
}
