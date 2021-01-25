package com.cowboysmall.scratch.cartrawler.util;

import java.util.function.Predicate;


public class Filters {

    public static <R> Predicate<R> not(Predicate<R> predicate) {

        return predicate.negate();
    }
}
