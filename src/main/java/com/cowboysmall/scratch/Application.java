package com.cowboysmall.scratch;

import com.cowboysmall.scratch.util.EncDec;
import com.cowboysmall.scratch.util.InterleavedIterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Application {

    public static void main(String... args) {

        System.out.println(">>> Hello, World!");

        System.out.println(">>> \"vmxibkgrlm\" - > " + EncDec.decode("vmxibkgrlm"));

        Iterator<String> iterator =
                new InterleavedIterator<>(
                        Arrays.asList("a", "b", "c", "d").iterator(),
                        Collections.emptyIterator(),
                        Arrays.asList("foo", "bar").iterator()
                );

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
