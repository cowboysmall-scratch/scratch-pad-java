package com.cowboysmall.scratch.cartrawler.model;


public enum Type {

    MINI("M"), ECONOMY("E"), COMPACT("C"), OTHER("O");

    private final String code;

    Type(String code) {

        this.code = code;
    }


    //_________________________________________________________________________

    public static Type getType(String code) {

        for (Type type : Type.values())
            if (type.code.equalsIgnoreCase(code))
                return type;

        return OTHER;
    }
}
