package com.cowboysmall.scratch.service;

import com.cowboysmall.scratch.domain.Payment;
import com.cowboysmall.scratch.repository.MockPaymentRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class PaymentProcessorTest {

    private static final String[] NAMES = new String[]{"NAME_1", "NAME_2", "NAME_3", "NAME_4", "NAME_5"};
    private static final String[] CURRENCIES = new String[]{"EUR", "USD", "GBP"};

    @Test
    public void testPaymentProcessor_MaximumThreeConcurrentPayments() throws Exception {

        MockPaymentRepository paymentRepository = new MockPaymentRepository();
        PaymentProcessor paymentProcessor = new PaymentProcessorImpl(paymentRepository);

        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            String name = NAMES[i % 5];
            String currency = CURRENCIES[i % 3];

            callables.add(() -> {
                paymentProcessor.process(
                        new Payment(
                                name,
                                "",
                                BigDecimal.TEN,
                                Currency.getInstance(currency),
                                new Date(System.currentTimeMillis())
                        )
                );
                return null;
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        executorService.invokeAll(callables);

        assertThat(paymentRepository.maxConcurrentCalls, is(lessThanOrEqualTo(3)));
    }

    @Test
    public void testPaymentProcessor_MaximumHundredPaymentsPerSecond_OneHundredPaymentsOverOneSecond() throws Exception {

        PaymentProcessor paymentProcessor = new PaymentProcessorImpl(payment -> {});

        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < 105; i++) {

            String name = NAMES[i % 5];
            String currency = CURRENCIES[i % 3];

            callables.add(() -> {
                paymentProcessor.process(
                        new Payment(
                                name,
                                "",
                                BigDecimal.TEN,
                                Currency.getInstance(currency),
                                new Date(System.currentTimeMillis())
                        )
                );
                return null;
            });
        }

        long start = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(105);
        executorService.invokeAll(callables);
        long duration = System.nanoTime() - start;

        assertThat(duration - 1000000000L, is(greaterThan(0L)));
    }

    @Test
    public void testPaymentProcessor_MaximumHundredPaymentsPerSecond_TwoHundredPaymentsOverTwoSecond() throws Exception {

        PaymentProcessor paymentProcessor = new PaymentProcessorImpl(payment -> {});

        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < 205; i++) {

            String name = NAMES[i % 5];
            String currency = CURRENCIES[i % 3];

            callables.add(() -> {
                paymentProcessor.process(
                        new Payment(
                                name,
                                "",
                                BigDecimal.TEN,
                                Currency.getInstance(currency),
                                new Date(System.currentTimeMillis())
                        )
                );
                return null;
            });
        }

        long start = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(205);
        executorService.invokeAll(callables);
        long duration = System.nanoTime() - start;

        assertThat(duration - 2000000000L, is(greaterThan(0L)));
    }
}
