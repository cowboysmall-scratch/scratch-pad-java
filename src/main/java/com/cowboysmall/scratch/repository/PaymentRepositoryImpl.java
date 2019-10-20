package com.cowboysmall.scratch.repository;

import com.cowboysmall.scratch.domain.Payment;
import com.cowboysmall.scratch.util.Payments;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.String.format;

public class PaymentRepositoryImpl implements PaymentRepository {

    private static final BigDecimal DAILY_LIMIT = new BigDecimal(50000);
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("ddMMyyyy");

    private final Lock lock = new ReentrantLock();

    private ConcurrentMap<String, ConcurrentMap<String, ConcurrentMap<String, Payments>>> dataStore = new ConcurrentHashMap<>();


    //_________________________________________________________________________

    @Override
    public void persist(Payment payment) {

        String date = FORMAT.format(payment.getSettlementDate());
        String currency = payment.getCurrency().getCurrencyCode();
        String creditor = payment.getCreditor();

        lock.lock();
        try {

            Payments payments = getPayments(date, currency, creditor);

            if (payments.getTotal().add(payment.getAmount()).compareTo(DAILY_LIMIT) > 0)
                throw new PaymentRepositoryException(format("Daily Payments Total Exceeded For %s In %s.", creditor, currency));

            payments.add(payment);

        } finally {

            lock.unlock();
        }
    }


    //_________________________________________________________________________

    private Payments getPayments(String date, String currency, String creditor) {

        if (!dataStore.containsKey(creditor))
            dataStore.put(creditor, new ConcurrentHashMap<>());

        if (!dataStore.get(creditor).containsKey(date))
            dataStore.get(creditor).put(date, new ConcurrentHashMap<>());

        if (!dataStore.get(creditor).get(date).containsKey(currency))
            dataStore.get(creditor).get(date).put(currency, new Payments());

        return dataStore.get(creditor).get(date).get(currency);
    }
}
