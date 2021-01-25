package com.cowboysmall.scratch.cartrawler.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class CarResultTest {

    public static final CarResult CAR_RESULT_1 =
            new CarResult("Volkswagen Polo", "NIZA", "EDMR", FuelPolicy.FULLEMPTY, 12.81d);
    public static final CarResult CAR_RESULT_2 =
            new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", FuelPolicy.FULLEMPTY, 22.04d);
    public static final CarResult CAR_RESULT_3 =
            new CarResult("Volkswagen Up", "NIZA", "MDMR", FuelPolicy.FULLEMPTY, 9.78d);
    public static final CarResult CAR_RESULT_4 =
            new CarResult("Renault Scenic Diesel", "NIZA", "JGAD", FuelPolicy.FULLEMPTY, 93.67d);
    public static final CarResult CAR_RESULT_5 =
            new CarResult("Ford Focus Estate", "AVIS", "CWMR", FuelPolicy.FULLFULL, 291.28d);


    @Test
    public void testCarResult_IsEconomy() {

        assertThat(CAR_RESULT_1.isEconomy(), is(true));
        assertThat(CAR_RESULT_2.isEconomy(), is(false));
        assertThat(CAR_RESULT_3.isEconomy(), is(false));
        assertThat(CAR_RESULT_4.isEconomy(), is(false));
    }

    @Test
    public void testCarResult_IsCompact() {

        assertThat(CAR_RESULT_1.isCompact(), is(false));
        assertThat(CAR_RESULT_2.isCompact(), is(true));
        assertThat(CAR_RESULT_3.isCompact(), is(false));
        assertThat(CAR_RESULT_4.isCompact(), is(false));
    }

    @Test
    public void testCarResult_IsMini() {

        assertThat(CAR_RESULT_1.isMini(), is(false));
        assertThat(CAR_RESULT_2.isMini(), is(false));
        assertThat(CAR_RESULT_3.isMini(), is(true));
        assertThat(CAR_RESULT_4.isMini(), is(false));
    }

    @Test
    public void testCarResult_IsOther() {

        assertThat(CAR_RESULT_1.isOther(), is(false));
        assertThat(CAR_RESULT_2.isOther(), is(false));
        assertThat(CAR_RESULT_3.isOther(), is(false));
        assertThat(CAR_RESULT_4.isOther(), is(true));
    }

    @Test
    public void testCarResult_isCorporate() {

        assertThat(CAR_RESULT_1.isCorporate(), is(false));
        assertThat(CAR_RESULT_2.isCorporate(), is(false));
        assertThat(CAR_RESULT_3.isCorporate(), is(false));
        assertThat(CAR_RESULT_4.isCorporate(), is(false));
        assertThat(CAR_RESULT_5.isCorporate(), is(true));
    }

    @Test
    public void testCarResult_isFuelPolicyFullFull() {

        assertThat(CAR_RESULT_1.isFuelPolicyFullFull(), is(false));
        assertThat(CAR_RESULT_2.isFuelPolicyFullFull(), is(false));
        assertThat(CAR_RESULT_3.isFuelPolicyFullFull(), is(false));
        assertThat(CAR_RESULT_4.isFuelPolicyFullFull(), is(false));
        assertThat(CAR_RESULT_5.isFuelPolicyFullFull(), is(true));
    }

    @Test
    public void testCarResult_isFuelPolicyFullEmpty() {

        assertThat(CAR_RESULT_1.isFuelPolicyFullEmpty(), is(true));
        assertThat(CAR_RESULT_2.isFuelPolicyFullEmpty(), is(true));
        assertThat(CAR_RESULT_3.isFuelPolicyFullEmpty(), is(true));
        assertThat(CAR_RESULT_4.isFuelPolicyFullEmpty(), is(true));
        assertThat(CAR_RESULT_5.isFuelPolicyFullEmpty(), is(false));
    }
}
