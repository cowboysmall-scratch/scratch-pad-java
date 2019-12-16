package com.cowboysmall.scratch.deveire.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SetOperationsTest {

    @Test
    public void testSetOperations_Union() {

        assertThat(
                SetOperations.union(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(2, 3, 4)
                ),
                is(new HashSet<>(Arrays.asList(1, 2, 3, 4)))
        );
    }

    @Test
    public void testSetOperations_Intersection() {

        assertThat(
                SetOperations.intersection(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(2, 3, 4)
                ),
                is(new HashSet<>(Arrays.asList(2, 3)))
        );
    }

    @Test
    public void testSetOperations_Difference() {

        assertThat(
                SetOperations.difference(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(2, 3, 4)
                ),
                is(new HashSet<>(Collections.singletonList(1)))
        );

        assertThat(
                SetOperations.difference(
                        Arrays.asList(2, 3, 4),
                        Arrays.asList(1, 2, 3)
                ),
                is(new HashSet<>(Collections.singletonList(4)))
        );
    }
}
