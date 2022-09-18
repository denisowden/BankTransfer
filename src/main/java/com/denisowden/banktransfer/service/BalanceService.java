package com.denisowden.banktransfer.service;

import com.denisowden.banktransfer.entity.Card;
import com.denisowden.banktransfer.exception.NotEnoughMoneyException;
import com.denisowden.banktransfer.mapper.CardMapper;
import com.denisowden.banktransfer.model.CardDto;
import com.denisowden.banktransfer.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BalanceService {

    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    public CardDto getCard(Integer number) {
        return cardMapper.toDto(cardRepository.findByNumber(number));
    }

    public CardDto addMoney(Integer cardNumber, BigDecimal amount) {
        Card card = cardRepository.findByNumber(cardNumber);
        card.setAmount(card.getAmount().add(amount));
        cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    public List<CardDto> transferMoney(Integer fromNumberCard, Integer toNumberCard, BigDecimal amount){

        Card fromCard = cardRepository.findByNumber(fromNumberCard);
        Card toCard = cardRepository.findByNumber(toNumberCard);
        if(fromCard == null || toCard == null) throw new NotEnoughMoneyException("Такой карты не существует");
        if(fromCard.getAmount().compareTo(amount) < 0) throw new NotEnoughMoneyException("Недостаточно денег на вашей карте");
        fromCard.setAmount(fromCard.getAmount().subtract(amount));
        toCard.setAmount(toCard.getAmount().add(amount));
        cardRepository.save(fromCard);
        cardRepository.save(toCard);
        List<CardDto> cardDtos = new ArrayList<>();
        cardDtos.add(cardMapper.toDto(fromCard));
        cardDtos.add(cardMapper.toDto(toCard));
        return cardDtos;
    }
}
