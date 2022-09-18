package com.denisowden.banktransfer.service;

import com.denisowden.banktransfer.entity.Card;
import com.denisowden.banktransfer.entity.User;
import com.denisowden.banktransfer.mapper.CardMapper;
import com.denisowden.banktransfer.model.CardDto;
import com.denisowden.banktransfer.repository.CardRepository;
import com.denisowden.banktransfer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardService {

    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public List<CardDto> getCard() {
        return cardRepository.
                findAll().
                stream().
                map(cardMapper::toDto).
                collect(Collectors.toList());
    }

    public CardDto createCard(Card card, Integer userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        card.setUser(user);
        return cardMapper.toDto(cardRepository.save(card));
    }

    public Integer deleteCard(Integer id) {
        cardRepository.deleteById(id);
        return id;
    }
}
