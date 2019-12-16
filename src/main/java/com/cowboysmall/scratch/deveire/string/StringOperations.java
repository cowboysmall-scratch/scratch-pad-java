package com.cowboysmall.scratch.deveire.string;

import java.util.Arrays;


public class StringOperations {

    public static boolean isAnagram(String first, String second) {

        String f = first.replaceAll("[^a-zA-Z]", "");
        String s = second.replaceAll("[^a-zA-Z]", "");

        if (f.length() != s.length())
            return false;

        char[] ff = f.toLowerCase().toCharArray();
        char[] ss = s.toLowerCase().toCharArray();

        Arrays.sort(ff);
        Arrays.sort(ss);

        return Arrays.equals(ff, ss);
    }
}
