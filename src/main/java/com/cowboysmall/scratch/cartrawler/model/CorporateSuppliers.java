package com.cowboysmall.scratch.cartrawler.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CorporateSuppliers {

    private static final Set<String> CORPORATE_SUPPLIERS =
            Stream.of(
                    "AVIS",
                    "BUDGET",
                    "ENTERPRISE",
                    "FIREFLY",
                    "HERTZ",
                    "SIXT",
                    "THRIFTY"
            ).collect(Collectors.toSet());


    //_________________________________________________________________________

    public static boolean isCorporateSupplier(String supplierName) {

        return CORPORATE_SUPPLIERS.contains(supplierName);
    }
}
