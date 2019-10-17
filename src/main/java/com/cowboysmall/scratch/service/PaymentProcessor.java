package com.cowboysmall.scratch.service;

import com.cowboysmall.scratch.domain.Payment;

public interface PaymentProcessor {

    void process(Payment payment);
}
