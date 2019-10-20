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

    private final ConcurrentMap<String, Payments> dataStore = new ConcurrentHashMap<>();


    //_________________________________________________________________________

    @Override
    public void persist(Payment payment) {

        String creditor = payment.getCreditor();
        String date = FORMAT.format(payment.getSettlementDate());
        String currency = payment.getCurrency().getCurrencyCode();

        lock.lock();
        try {

            Payments payments = getPayments(format("%s-%s-%s", creditor, date, currency));

            if (payments.getTotal().add(payment.getAmount()).compareTo(DAILY_LIMIT) > 0)
                throw new PaymentRepositoryException(
                        format(
                                "Daily Payments Total Exceeded For %s On %s In %s.",
                                creditor,
                                date,
                                currency
                        )
                );

            payments.add(payment);

        } finally {

            lock.unlock();
        }
    }


    //_________________________________________________________________________

    private Payments getPayments(String key) {

        if (!dataStore.containsKey(key))
            dataStore.put(key, new Payments());

        return dataStore.get(key);
    }
}
