package com.cowboysmall.scratch.bionic.question3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class WeatherForecastService {

    @Autowired
    private Thermometer thermometer;

    @Autowired
    private TemperatureMeasurementCallback callback;

    @Scheduled(fixedRate = 50)
    public void takeTemperatureMeasurement() {

        callback.temperatureMeasured(thermometer.measure());
    }
}
