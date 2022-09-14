package com.denisowden.banktransfer.service;

import com.denisowden.banktransfer.entity.CardEntity;
import com.denisowden.banktransfer.exception.NotEnoughMoneyException;
import com.denisowden.banktransfer.model.Card;
import com.denisowden.banktransfer.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BalanceService {

    private final CardRepository cardRepository;
    public Card getCard(Integer number) {
        return Card.toModel(cardRepository.findByNumber(number));
    }

    public Card addMoney(Integer cardNumber, BigDecimal amount) {
        CardEntity card = cardRepository.findByNumber(cardNumber);
        card.setAmount(card.getAmount().add(amount));
        cardRepository.save(card);
        return Card.toModel(card);
    }

    public List<Card> transferMoney(Integer fromNumberCard, Integer toNumberCard, BigDecimal amount){

        CardEntity fromCard = cardRepository.findByNumber(fromNumberCard);
        CardEntity toCard = cardRepository.findByNumber(toNumberCard);
        if(fromCard == null || toCard == null) throw new NotEnoughMoneyException("Такой карты не существует");
        if(fromCard.getAmount().compareTo(amount) < 0) throw new NotEnoughMoneyException("Недостаточно денег на вашей карте");
        fromCard.setAmount(fromCard.getAmount().subtract(amount));
        toCard.setAmount(toCard.getAmount().add(amount));
        cardRepository.save(fromCard);
        cardRepository.save(toCard);
        List<Card> cards = new ArrayList<>();
        cards.add(Card.toModel(fromCard));
        cards.add(Card.toModel(toCard));
        return cards;
    }
}
