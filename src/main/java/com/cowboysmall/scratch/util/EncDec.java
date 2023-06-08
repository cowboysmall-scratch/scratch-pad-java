package com.cowboysmall.scratch.util;

import java.util.stream.Collectors;

public class EncDec {

    public static String decode(String s) {

        return s.chars()
                .mapToObj(c ->
                        97 <= c && c <= 122
                                ? Character.toString((char) (219 - c))
                                : Character.toString((char) c)
                )
                .collect(Collectors.joining());
    }
}
