package com.cowboysmall.scratch;

import static java.util.Arrays.copyOfRange;


public class Driver {

    public static void main(String... args) throws Exception {

        if (args.length > 0) {

            Class<?> clazz = Class.forName(args[0]);

            clazz.getMethod("main", String[].class)
                    .invoke(
                            clazz.getDeclaredConstructor().newInstance(),
                            (Object) copyOfRange(args, 1, args.length)
                    );
        }
    }
}
