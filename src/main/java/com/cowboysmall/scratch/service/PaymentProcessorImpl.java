package com.cowboysmall.scratch.service;

import com.cowboysmall.scratch.domain.Payment;
import com.cowboysmall.scratch.repository.PaymentRepository;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.Semaphore;

public class PaymentProcessorImpl implements PaymentProcessor {

    private RateLimiter rateLimiter = RateLimiter.create(100);
    private Semaphore semaphore = new Semaphore(3);

    private PaymentRepository paymentRepository;


    //_________________________________________________________________________

    public PaymentProcessorImpl(PaymentRepository paymentRepository) {

        this.paymentRepository = paymentRepository;
    }


    //_________________________________________________________________________

    @Override
    public void process(Payment payment) {


        try {

            rateLimiter.acquire();
            semaphore.acquire();

            try {

                paymentRepository.persist(payment);

            } finally {

                semaphore.release();
            }

        } catch (InterruptedException e) {

            throw new PaymentProcessorException(e);
        }
    }
}
