package com.cowboysmall.scratch.repository;

import com.cowboysmall.scratch.domain.Payment;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.max;

public class MockPaymentRepository implements PaymentRepository {

    private AtomicInteger concurrentCalls = new AtomicInteger(0);

    public int maxConcurrentCalls = 0;


    //_________________________________________________________________________

    @Override
    public void persist(Payment payment) {

        maxConcurrentCalls = max(maxConcurrentCalls, concurrentCalls.incrementAndGet());
        maxConcurrentCalls = max(maxConcurrentCalls, concurrentCalls.getAndDecrement());
    }
}
