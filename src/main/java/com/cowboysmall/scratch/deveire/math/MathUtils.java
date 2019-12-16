package com.cowboysmall.scratch.deveire.math;

import java.util.List;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.log;


public class MathUtils {

    public static boolean isPowerOfTwo(Long number) {

        return number != 0 && ceil(log(number) / log(2)) == floor(log(number) / log(2));
    }

    public static boolean isPowerOfTwoBitwise(Long number) {

        return number != 0 && ((number & (number - 1)) == 0);
    }


    //_________________________________________________________________________

    public static double mean(List<Double> numbers) {

        double mean = 0.0;
        double count = 0.0;

        for (Double number : numbers) {

            mean = ((count / (count + 1.0)) * mean) + (1 / (count + 1.0)) * number;
            count += 1.0;
        }

        return mean;
    }
}
