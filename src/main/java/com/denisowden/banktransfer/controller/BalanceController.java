package com.denisowden.banktransfer.controller;

import com.denisowden.banktransfer.exception.NotEnoughMoneyException;
import com.denisowden.banktransfer.model.Card;
import com.denisowden.banktransfer.service.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController(value = "/balance")
@AllArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping(value = "/balance/{cardNumber}")
    public Card getBalance(@PathVariable Integer cardNumber){
        return balanceService.getCard(cardNumber);
    }

    @PostMapping(value = "/balance")
    public Card addMoney(@RequestParam Integer cardNumber,
                         @RequestParam BigDecimal amount){
        return balanceService.addMoney(cardNumber, amount);
    }

    @PutMapping(value = "/balance/{fromNumberCard}")
    public List<Card> transferMoney(@PathVariable Integer fromNumberCard,
                                    @RequestParam Integer toNumberCard,
                                    @RequestParam BigDecimal amount){

            return balanceService.transferMoney(fromNumberCard, toNumberCard, amount);
    }
}
