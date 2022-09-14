package com.denisowden.banktransfer.controller;

import com.denisowden.banktransfer.entity.CardEntity;
import com.denisowden.banktransfer.model.Card;
import com.denisowden.banktransfer.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
@AllArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getCard(){
        return cardService.getCard();
    }

    @PostMapping
    public Card createCard(@RequestBody CardEntity cardEntity,
                           @RequestParam Integer userId){

        return cardService.createCard(cardEntity, userId);
    }

    @DeleteMapping(value = "/{id}")
    public Integer deleteCard(@PathVariable Integer id){
        return cardService.deleteCard(id);
    }
}
