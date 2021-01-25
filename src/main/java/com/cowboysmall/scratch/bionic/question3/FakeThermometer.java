package com.cowboysmall.scratch.bionic.question3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FakeThermometer implements Thermometer {

    private int currentTemperature = 21;

    @Override
    public int measure() {

        return currentTemperature++;
    }
}
