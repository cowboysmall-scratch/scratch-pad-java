package com.cowboysmall.scratch.deveire.math.number;

import java.math.BigInteger;

public class AddableBigInteger extends AddableNumber<BigInteger> {

    private final BigInteger value;

    public AddableBigInteger(BigInteger value) {

        this.value = value;
    }


    //_________________________________________________________________________

    @Override
    public AddableNumber<BigInteger> add(AddableNumber<BigInteger> addableNumber) {

        return new AddableBigInteger(value.add(addableNumber.getValue()));
    }

    @Override
    public BigInteger getValue() {

        return value;
    }


    //_________________________________________________________________________

    @Override
    public int intValue() {

        return value.intValue();
    }

    @Override
    public long longValue() {

        return value.longValue();
    }

    @Override
    public float floatValue() {

        return value.floatValue();
    }

    @Override
    public double doubleValue() {

        return value.doubleValue();
    }
}
