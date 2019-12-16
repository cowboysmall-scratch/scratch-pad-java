package com.cowboysmall.scratch.deveire.math.number;

import java.math.BigInteger;

public class AddableBigInteger extends AddableNumber<BigInteger> {

    private final BigInteger bigInteger;

    public AddableBigInteger(BigInteger bigInteger) {

        this.bigInteger = bigInteger;
    }


    //_________________________________________________________________________

    @Override
    public AddableNumber<BigInteger> add(AddableNumber<BigInteger> addableNumber) {

        return new AddableBigInteger(bigInteger.add(addableNumber.getValue()));
    }

    @Override
    public BigInteger getValue() {

        return bigInteger;
    }


    //_________________________________________________________________________

    @Override
    public int intValue() {

        return bigInteger.intValue();
    }

    @Override
    public long longValue() {

        return bigInteger.longValue();
    }

    @Override
    public float floatValue() {

        return bigInteger.floatValue();
    }

    @Override
    public double doubleValue() {

        return bigInteger.doubleValue();
    }
}
