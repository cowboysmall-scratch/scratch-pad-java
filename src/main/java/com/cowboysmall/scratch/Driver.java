package com.cowboysmall.scratch;

import java.lang.reflect.Method;

import static java.util.Arrays.copyOfRange;

public class Driver {

    public static void main(String... args) throws Exception {

        if (args.length > 0) {

            Class<?> clazz = Class.forName(args[0]);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Method main = clazz.getMethod("main", String[].class);

            if (args.length > 1)
                main.invoke(instance, (Object) copyOfRange(args, 1, args.length + 1));
            else
                main.invoke(instance, (Object) new String[0]);
        }
    }
}
