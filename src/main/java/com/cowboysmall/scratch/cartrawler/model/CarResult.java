package com.cowboysmall.scratch.cartrawler.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CarResult {

    public static final Set<String> CORPORATE_SUPPLIERS =
            Stream.of("AVIS", "BUDGET", "ENTERPRISE", "FIREFLY", "HERTZ", "SIXT", "THRIFTY")
                    .collect(Collectors.toSet());

    private final String description;
    private final String supplierName;
    private final String sippCode;
    private final double rentalCost;
    private final FuelPolicy fuelPolicy;


    //_________________________________________________________________________

    public CarResult(String description, String supplierName, String sippCode, double rentalCost, FuelPolicy fuelPolicy) {

        this.description = description;
        this.supplierName = supplierName;
        this.sippCode = sippCode;
        this.rentalCost = rentalCost;
        this.fuelPolicy = fuelPolicy;
    }


    //_________________________________________________________________________

    public String getDescription() {

        return description;
    }

    public String getSupplierName() {

        return supplierName;
    }

    public String getSippCode() {

        return sippCode;
    }

    public double getRentalCost() {

        return rentalCost;
    }

    public FuelPolicy getFuelPolicy() {

        return fuelPolicy;
    }


    //_________________________________________________________________________

    public boolean isCorporate() {

        return CORPORATE_SUPPLIERS.contains(supplierName);
    }

    public boolean isMini() {

        return sippCode.startsWith("M");
    }

    public boolean isEconomy() {

        return sippCode.startsWith("E");
    }

    public boolean isCompact() {

        return sippCode.startsWith("C");
    }

    public boolean isOther() {

        return !isMini() && !isEconomy() && !isCompact();
    }

    public boolean isFuelPolicyFullFull() {

        return fuelPolicy == FuelPolicy.FULLFULL;
    }

    public boolean isFuelPolicyFullEmpty() {

        return fuelPolicy == FuelPolicy.FULLEMPTY;
    }


    //_________________________________________________________________________

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarResult carResult = (CarResult) o;
        return description.equals(carResult.description) &&
                supplierName.equals(carResult.supplierName) &&
                sippCode.equals(carResult.sippCode) &&
                fuelPolicy == carResult.fuelPolicy;
    }

    @Override
    public int hashCode() {

        return Objects.hash(description, supplierName, sippCode, fuelPolicy);
    }


    //_________________________________________________________________________

    public String toString() {

        return String.format(
                "%-10s\t%-30s\t%-10s\t%6.2f\t%10s",
                supplierName,
                description,
                sippCode,
                rentalCost,
                fuelPolicy
        );
    }
}
