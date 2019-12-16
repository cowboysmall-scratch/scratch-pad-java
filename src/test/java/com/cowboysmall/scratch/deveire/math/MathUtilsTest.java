package com.cowboysmall.scratch.deveire.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MathUtilsTest {

    @Test
    public void testMathUtils_Mean() {

        assertThat(MathUtils.mean(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)), is(3.0));
        assertThat(MathUtils.mean(Arrays.asList(1.0, 2.0, 3.0, 4.0, 4.0)), is(2.8));
    }

    @Test
    public void testMathUtils_Mean_LargeList() {

        List<Double> numbers =
                IntStream.range(1, 1000000)
                        .mapToDouble(Double::valueOf)
                        .boxed()
                        .collect(Collectors.toList());

        assertThat(MathUtils.mean(numbers), is(500000.0));
    }

    @Test
    public void testMathUtils_isPowerOfTwo() {

        assertThat(MathUtils.isPowerOfTwo(1L), is(true));
        assertThat(MathUtils.isPowerOfTwo(2L), is(true));
        assertThat(MathUtils.isPowerOfTwo(4L), is(true));
        assertThat(MathUtils.isPowerOfTwo(8L), is(true));
        assertThat(MathUtils.isPowerOfTwo(16L), is(true));
        assertThat(MathUtils.isPowerOfTwo(32L), is(true));
        assertThat(MathUtils.isPowerOfTwo(64L), is(true));
        assertThat(MathUtils.isPowerOfTwo(128L), is(true));
        assertThat(MathUtils.isPowerOfTwo(256L), is(true));

        assertThat(MathUtils.isPowerOfTwo(0L), is(false));
        assertThat(MathUtils.isPowerOfTwo(48L), is(false));
        assertThat(MathUtils.isPowerOfTwo(640L), is(false));
    }

    @Test
    public void testMathUtils_isPowerOfTwoBitwise() {

        assertThat(MathUtils.isPowerOfTwoBitwise(1L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(2L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(4L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(8L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(16L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(32L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(64L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(128L), is(true));
        assertThat(MathUtils.isPowerOfTwoBitwise(256L), is(true));

        assertThat(MathUtils.isPowerOfTwoBitwise(0L), is(false));
        assertThat(MathUtils.isPowerOfTwoBitwise(48L), is(false));
        assertThat(MathUtils.isPowerOfTwoBitwise(640L), is(false));
    }
}
