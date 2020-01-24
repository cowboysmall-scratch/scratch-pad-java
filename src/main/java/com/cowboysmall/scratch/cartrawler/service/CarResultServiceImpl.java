package com.cowboysmall.scratch.cartrawler.service;

import com.cowboysmall.scratch.cartrawler.component.CarResultProcessor;
import com.cowboysmall.scratch.cartrawler.model.CarResult;
import com.cowboysmall.scratch.cartrawler.repository.CarResultRepository;

import java.util.List;
import java.util.stream.Collectors;


public class CarResultServiceImpl implements CarResultService {

    private CarResultRepository carResultRepository;

    private CarResultProcessor carResultProcessor;


    //_________________________________________________________________________

    public CarResultServiceImpl(CarResultRepository carResultRepository, CarResultProcessor carResultProcessor) {

        this.carResultRepository = carResultRepository;
        this.carResultProcessor = carResultProcessor;
    }


    //_________________________________________________________________________

    @Override
    public List<CarResult> getAllCarResults() {

        List<CarResult> carResults = carResultRepository.getAllCarResults();

        return carResultProcessor.processCarResults(
                carResults.stream()
                        .distinct()
                        .collect(Collectors.toList())
        );
    }
}
