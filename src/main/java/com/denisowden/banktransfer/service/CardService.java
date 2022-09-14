package com.denisowden.banktransfer.service;

import com.denisowden.banktransfer.entity.CardEntity;
import com.denisowden.banktransfer.entity.UserEntity;
import com.denisowden.banktransfer.model.Card;
import com.denisowden.banktransfer.repository.CardRepository;
import com.denisowden.banktransfer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public List<Card> getCard() {
        return cardRepository.
                findAll().
                stream().
                map(Card::toModel).
                collect(Collectors.toList());
    }

    public Card createCard(CardEntity cardEntity, Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        cardEntity.setUser(userEntity);
        return Card.toModel(cardRepository.save(cardEntity));
    }

    public Integer deleteCard(Integer id) {
        cardRepository.deleteById(id);
        return id;
    }
}
