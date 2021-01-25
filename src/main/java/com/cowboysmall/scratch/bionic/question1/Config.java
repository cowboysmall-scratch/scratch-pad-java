package com.cowboysmall.scratch.bionic.question1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import({LoggerAOP.class, NameRepository.class})
public class Config {

    @Bean
    public Logger logger() {

        return System.out::println;
    }
}
