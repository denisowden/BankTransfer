package com.denisowden.banktransfer.controller;

import com.denisowden.banktransfer.model.CardDto;
import com.denisowden.banktransfer.service.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/balance")
@AllArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    public CardDto getBalance(@RequestBody Integer cardNumber) {
        return balanceService.getCard(cardNumber);
    }

    @PostMapping
    public CardDto addMoney(@RequestParam Integer cardNumber,
                         @RequestParam BigDecimal amount) {
        return balanceService.addMoney(cardNumber, amount);
    }

    @PutMapping(value = "/{fromNumberCard}")
    public List<CardDto> transferMoney(@PathVariable Integer fromNumberCard,
                                    @RequestParam Integer toNumberCard,
                                    @RequestParam BigDecimal amount) {

        return balanceService.transferMoney(fromNumberCard, toNumberCard, amount);
    }
}
