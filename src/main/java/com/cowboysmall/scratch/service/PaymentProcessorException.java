package com.cowboysmall.scratch.service;

public class PaymentProcessorException extends RuntimeException {

    public PaymentProcessorException(Throwable cause) {

        super(cause);
    }

    public PaymentProcessorException(String message) {

        super(message);
    }
}
