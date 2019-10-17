package com.cowboysmall.scratch.repository;

import com.cowboysmall.scratch.domain.Payment;

public interface PaymentRepository {

    void persist(Payment payment);
}
