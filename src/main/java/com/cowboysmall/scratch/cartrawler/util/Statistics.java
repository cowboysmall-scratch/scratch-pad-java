package com.cowboysmall.scratch.cartrawler.util;

import java.util.List;


public class Statistics {

    public static double calculateMedian(List<Double> doubleList) {

        int size = doubleList.size();
        return size % 2 == 0
                ? (doubleList.get((size / 2) - 1) + doubleList.get(size / 2)) / 2
                : doubleList.get(size / 2);
    }
}
