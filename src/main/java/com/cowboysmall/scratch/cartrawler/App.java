package com.cowboysmall.scratch.cartrawler;

import com.cowboysmall.scratch.cartrawler.component.CarResultProcessorImpl;
import com.cowboysmall.scratch.cartrawler.repository.CarResultRepositoryImpl;
import com.cowboysmall.scratch.cartrawler.service.CarResultServiceImpl;


public class App {

    public static void main(String... args) {

        new CarResultServiceImpl(

                new CarResultRepositoryImpl(),
                new CarResultProcessorImpl(args.length > 0 && args[0].equals("--median-filter"))

        ).getAllCarResults().forEach(System.out::println);
    }
}