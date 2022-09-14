package com.denisowden.banktransfer.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
