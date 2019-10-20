package com.cowboysmall.scratch.util;

import com.cowboysmall.scratch.domain.Payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Payments {

    private final List<Payment> payments = new ArrayList<>();

    private BigDecimal total = new BigDecimal(0);


    //_________________________________________________________________________

    public List<Payment> getPayments() {
        return payments;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public int size() {
        return payments.size();
    }


    //_________________________________________________________________________

    public boolean add(Payment payment) {

        total = total.add(payment.getAmount());
        return payments.add(payment);
    }
}
