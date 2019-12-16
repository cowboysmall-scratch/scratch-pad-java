package com.cowboysmall.scratch.deveire.math.number;

import java.math.BigDecimal;

public class AddableBigDecimal extends AddableNumber<BigDecimal> {

    private final BigDecimal bigDecimal;

    public AddableBigDecimal(BigDecimal bigDecimal) {

        this.bigDecimal = bigDecimal;
    }


    //_________________________________________________________________________

    @Override
    public AddableNumber<BigDecimal> add(AddableNumber<BigDecimal> addableNumber) {

        return new AddableBigDecimal(bigDecimal.add(addableNumber.getValue()));
    }

    @Override
    public BigDecimal getValue() {

        return bigDecimal;
    }


    //_________________________________________________________________________

    @Override
    public int intValue() {

        return bigDecimal.intValue();
    }

    @Override
    public long longValue() {

        return bigDecimal.longValue();
    }

    @Override
    public float floatValue() {

        return bigDecimal.floatValue();
    }

    @Override
    public double doubleValue() {

        return bigDecimal.doubleValue();
    }
}
