package com.cowboysmall.scratch.deveire.math;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SetOperations {

    public static <T> Set<T> union(List<T> a, List<T> b) {

        return Stream.concat(a.stream(), b.stream()).collect(Collectors.toSet());
    }

    public static <T> Set<T> intersection(List<T> a, List<T> b) {

        return a.stream().filter(b::contains).collect(Collectors.toSet());
    }

    public static <T> Set<T> difference(List<T> a, List<T> b) {

        return a.stream().filter(val -> !b.contains(val)).collect(Collectors.toSet());
    }
}
