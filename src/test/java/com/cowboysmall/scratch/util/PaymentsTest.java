package com.cowboysmall.scratch.util;

import com.cowboysmall.scratch.domain.Payment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentsTest {

    @Test
    public void testPayments_AddUpdatesTotal() {

        Payments payments = new Payments();

        payments.add(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(5000),
                        Currency.getInstance("EUR"),
                        new Date(System.currentTimeMillis())
                )
        );

        payments.add(
                new Payment(
                        "John Smith",
                        "",
                        new BigDecimal(5000),
                        Currency.getInstance("EUR"),
                        new Date(System.currentTimeMillis())
                )
        );

        assertThat(payments.size(), is(2));
        assertThat(payments.getTotal(), is(new BigDecimal(10000)));
    }
}
