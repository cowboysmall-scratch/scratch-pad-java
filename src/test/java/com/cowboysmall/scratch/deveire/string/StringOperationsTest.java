package com.cowboysmall.scratch.deveire.string;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class StringOperationsTest {

    @Test
    public void testStringOperations_IsAnagram() {

        assertThat(StringOperations.isAnagram("A man's rag", "anagrams"), is(true));
        assertThat(StringOperations.isAnagram("anagrams", "A man's rag"), is(true));

        assertThat(StringOperations.isAnagram("first", "second"), is(false));
        assertThat(StringOperations.isAnagram("second", "first"), is(false));
    }
}
