package com.cowboysmall.scratch.repository;

import com.cowboysmall.scratch.domain.Payment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentRepositoryTest {

    public static final long DAY_IN_MILLIS = 24 * 60 * 60 * 1000;


    //_________________________________________________________________________

    @Test
    public void testPaymentRepository_PaymentsExceedTotalAllowedPerDay() {

        PaymentRepository paymentRepository = new PaymentRepositoryImpl();

        long now = System.currentTimeMillis();

        paymentRepository.persist(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(50000),
                        Currency.getInstance("EUR"),
                        new Date(now)
                )
        );

        assertThrows(PaymentRepositoryException.class, () -> {

            paymentRepository.persist(
                    new Payment(
                            "John Smith",
                            "",
                            new BigDecimal(50000),
                            Currency.getInstance("EUR"),
                            new Date(now + 1000)
                    )
            );
        });
    }

    @Test
    public void testPaymentRepository_PaymentsDoNotExceedTotalAllowedPerDay() {

        PaymentRepository paymentRepository = new PaymentRepositoryImpl();

        long now = System.currentTimeMillis();

        paymentRepository.persist(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(50000),
                        Currency.getInstance("EUR"),
                        new Date(now)
                )
        );

        paymentRepository.persist(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(50000),
                        Currency.getInstance("EUR"),
                        new Date(now + DAY_IN_MILLIS)
                )
        );
    }

    @Test
    public void testPaymentRepository_DifferentCreditors() {

        PaymentRepository paymentRepository = new PaymentRepositoryImpl();

        long now = System.currentTimeMillis();

        paymentRepository.persist(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(50000),
                        Currency.getInstance("EUR"),
                        new Date(now)
                )
        );

        paymentRepository.persist(
                new Payment(
                        "Karl Marx",
                        "",
                        new BigDecimal(50000),
                        Currency.getInstance("EUR"),
                        new Date(now)
                )
        );
    }

    @Test
    public void testPaymentRepository_DifferentCurrencies() {

        PaymentRepository paymentRepository = new PaymentRepositoryImpl();

        long now = System.currentTimeMillis();

        paymentRepository.persist(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(50000),
                        Currency.getInstance("EUR"),
                        new Date(now)
                )
        );

        paymentRepository.persist(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(50000),
                        Currency.getInstance("USD"),
                        new Date(now + 1000)
                )
        );
    }
}
