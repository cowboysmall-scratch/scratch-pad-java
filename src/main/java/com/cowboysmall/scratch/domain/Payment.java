package com.cowboysmall.scratch.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public final class Payment {

    private final String creditor;
    private final String remittance;
    private final BigDecimal amount;
    private final Currency currency;
    private final Date settlementDate;


    //_________________________________________________________________________

    public Payment(String creditor, String remittance, BigDecimal amount, Currency currency, Date settlementDate) {

        this.creditor = creditor;
        this.remittance = remittance;
        this.amount = amount;
        this.currency = currency;
        this.settlementDate = settlementDate;
    }


    //_________________________________________________________________________

    public String getCreditor() {
        return creditor;
    }

    public String getRemittance() {
        return remittance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }
}
