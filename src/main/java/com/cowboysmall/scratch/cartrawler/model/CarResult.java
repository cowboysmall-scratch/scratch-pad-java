package com.cowboysmall.scratch.cartrawler.model;

import static com.cowboysmall.scratch.cartrawler.model.CorporateSuppliers.isCorporateSupplier;
import static java.lang.String.format;
import static java.util.Objects.hash;


public class CarResult {

    private final String description;
    private final String supplierName;
    private final String sippCode;

    private final FuelPolicy fuelPolicy;

    private final double rentalCost;

    private final Type type;


    //_________________________________________________________________________

    public CarResult(String description, String supplierName, String sippCode, FuelPolicy fuelPolicy, double rentalCost) {

        this.description = description;
        this.supplierName = supplierName;
        this.sippCode = sippCode;
        this.fuelPolicy = fuelPolicy;
        this.rentalCost = rentalCost;

        this.type = Type.getType(sippCode.substring(0, 1));
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

    public FuelPolicy getFuelPolicy() {

        return fuelPolicy;
    }

    public double getRentalCost() {

        return rentalCost;
    }

    public Type getType() {

        return type;
    }


    //_________________________________________________________________________

    public boolean isCorporate() {

        return isCorporateSupplier(supplierName);
    }

    public boolean isMini() {

        return type == Type.MINI;
    }

    public boolean isEconomy() {

        return type == Type.ECONOMY;
    }

    public boolean isCompact() {

        return type == Type.COMPACT;
    }

    public boolean isOther() {

        return type == Type.OTHER;
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

        return hash(description, supplierName, sippCode, fuelPolicy);
    }


    //_________________________________________________________________________

    public String toString() {

        return format(
                "%-10s\t%-30s\t%-10s\t%6.2f\t%10s",
                supplierName,
                description,
                sippCode,
                rentalCost,
                fuelPolicy
        );
    }
}
