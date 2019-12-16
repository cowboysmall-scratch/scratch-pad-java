package com.cowboysmall.scratch.deveire.math.number;

import java.util.Objects;


public abstract class AddableNumber<T> extends Number {

    public abstract AddableNumber<T> add(AddableNumber<T> addableNumber);

    public abstract T getValue();


    //_________________________________________________________________________

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddableNumber<T> that = (AddableNumber<T>) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getValue());
    }

    @Override
    public String toString() {

        return getValue().toString();
    }
}
