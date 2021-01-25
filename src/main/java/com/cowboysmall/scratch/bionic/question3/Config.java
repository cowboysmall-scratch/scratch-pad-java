package com.cowboysmall.scratch.bionic.question3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Import({FakeThermometer.class, WeatherForecastService.class})
public class Config {

    @Bean
    public TemperatureMeasurementCallback callback() {

        return System.out::println;
    }
}
