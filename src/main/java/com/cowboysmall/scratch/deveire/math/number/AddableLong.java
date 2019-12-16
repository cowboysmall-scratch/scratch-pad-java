package com.cowboysmall.scratch.deveire.math.number;

public class AddableLong extends AddableNumber<Long> {

    private final Long value;

    public AddableLong(Long value) {

        this.value = value;
    }


    //_________________________________________________________________________

    @Override
    public AddableNumber<Long> add(AddableNumber<Long> addableNumber) {

        return new AddableLong(value + addableNumber.getValue());
    }

    @Override
    public Long getValue() {

        return value;
    }


    //_________________________________________________________________________

    @Override
    public int intValue() {

        return value.intValue();
    }

    @Override
    public long longValue() {

        return value;
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
