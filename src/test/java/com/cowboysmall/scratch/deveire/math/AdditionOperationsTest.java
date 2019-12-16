package com.cowboysmall.scratch.deveire.math;

import com.cowboysmall.scratch.deveire.math.number.AddableBigDecimal;
import com.cowboysmall.scratch.deveire.math.number.AddableBigInteger;
import com.cowboysmall.scratch.deveire.math.number.AddableInteger;
import com.cowboysmall.scratch.deveire.math.number.AddableLong;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AdditionOperationsTest {

    @Test
    public void testAdditionOperations_Add() {

        assertThat(
                AdditionOperations.add(
                        new AddableInteger(4),
                        new AddableInteger(5)
                ),
                is(new AddableInteger(9))
        );

        assertThat(
                AdditionOperations.add(
                        new AddableLong(444444444444L),
                        new AddableLong(555555555555L)
                ),
                is(new AddableLong(999999999999L))
        );

        assertThat(
                AdditionOperations.add(
                        new AddableBigInteger(new BigInteger("4")),
                        new AddableBigInteger(new BigInteger("5"))
                ),
                is(new AddableBigInteger(new BigInteger("9")))
        );

        assertThat(
                AdditionOperations.add(
                        new AddableBigDecimal(new BigDecimal("4.0")),
                        new AddableBigDecimal(new BigDecimal("5.0"))
                ),
                is(new AddableBigDecimal(new BigDecimal("9.0")))
        );
    }
}
