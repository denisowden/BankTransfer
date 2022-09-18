package com.denisowden.banktransfer.controller;

import com.denisowden.banktransfer.entity.Card;
import com.denisowden.banktransfer.model.CardDto;
import com.denisowden.banktransfer.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<CardDto> getCard(){
        return cardService.getCard();
    }

    @PostMapping
    public CardDto createCard(@RequestBody Card card,
                              @RequestParam Integer userId){

        return cardService.createCard(card, userId);
    }

    @DeleteMapping(value = "/{id}")
    public Integer deleteCard(@PathVariable Integer id){
        return cardService.deleteCard(id);
    }
}
