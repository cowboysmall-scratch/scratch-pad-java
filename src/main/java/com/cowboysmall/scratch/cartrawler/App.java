package com.cowboysmall.scratch.cartrawler;

import com.cowboysmall.scratch.cartrawler.component.CarResultProcessor;
import com.cowboysmall.scratch.cartrawler.component.CarResultProcessorImpl;
import com.cowboysmall.scratch.cartrawler.repository.CarResultRepository;
import com.cowboysmall.scratch.cartrawler.repository.CarResultRepositoryImpl;
import com.cowboysmall.scratch.cartrawler.service.CarResultService;
import com.cowboysmall.scratch.cartrawler.service.CarResultServiceImpl;


public class App {

    public static void main(String... args) {

        CarResultRepository carResultRepository =
                new CarResultRepositoryImpl();
        CarResultProcessor carResultProcessor =
                new CarResultProcessorImpl(args.length > 0 && args[0].equals("--median-filter"));

        CarResultService carResultService =
                new CarResultServiceImpl(carResultRepository, carResultProcessor);

        carResultService.getAllCarResults()
                .forEach(System.out::println);
    }
}