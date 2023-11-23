package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.DTO.Card;

public interface CardService {

    List<Card> getAllCards();

    Card createCard(Card card);

    void deleteCard(Integer id);

    Card getCardById(Integer id) throws Exception;
}
