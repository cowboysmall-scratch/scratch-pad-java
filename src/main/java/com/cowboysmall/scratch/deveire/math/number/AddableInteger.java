package com.cowboysmall.scratch.deveire.math.number;

public class AddableInteger extends AddableNumber<Integer> {

    private final Integer integer;

    public AddableInteger(Integer integer) {

        this.integer = integer;
    }


    //_________________________________________________________________________

    @Override
    public AddableNumber<Integer> add(AddableNumber<Integer> addableNumber) {

        return new AddableInteger(integer + addableNumber.intValue());
    }

    @Override
    public Integer getValue() {

        return integer;
    }


    //_________________________________________________________________________

    @Override
    public int intValue() {

        return integer;
    }

    @Override
    public long longValue() {

        return integer.longValue();
    }

    @Override
    public float floatValue() {

        return integer.floatValue();
    }

    @Override
    public double doubleValue() {

        return integer.doubleValue();
    }
}
