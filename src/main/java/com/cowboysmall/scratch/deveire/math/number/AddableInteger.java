package com.cowboysmall.scratch.deveire.math.number;

public class AddableInteger extends AddableNumber<Integer> {

    private final Integer value;

    public AddableInteger(Integer value) {

        this.value = value;
    }


    //_________________________________________________________________________

    @Override
    public AddableNumber<Integer> add(AddableNumber<Integer> addableNumber) {

        return new AddableInteger(value + addableNumber.getValue());
    }

    @Override
    public Integer getValue() {

        return value;
    }


    //_________________________________________________________________________

    @Override
    public int intValue() {

        return value;
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
