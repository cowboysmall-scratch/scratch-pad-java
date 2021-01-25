package com.cowboysmall.scratch.bionic.question3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver3 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(Config.class);
        config.refresh();
    }
}
