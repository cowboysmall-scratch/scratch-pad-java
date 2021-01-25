package com.cowboysmall.scratch.cartrawler.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class StatisticsTest {

    @Test
    public void testStatistics_CalculateMedian_Odd() {

        List<Double> integers = Arrays.asList(8.0d, 7.0d, 6.0d, 5.0d, 4.0d, 3.0d, 2.0d);
        Collections.sort(integers);

        assertThat(Statistics.calculateMedian(integers), is(5.0d));
    }

    @Test
    public void testStatistics_CalculateMedian_Even() {

        List<Double> integers = Arrays.asList(8.0d, 7.0d, 6.0d, 5.0d, 4.0d, 3.0d, 2.0d, 1.0d);
        Collections.sort(integers);

        assertThat(Statistics.calculateMedian(integers), is(4.5d));
    }
}
