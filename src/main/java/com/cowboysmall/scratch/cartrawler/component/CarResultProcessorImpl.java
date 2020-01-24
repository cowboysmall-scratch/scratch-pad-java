package com.cowboysmall.scratch.cartrawler.component;

import com.cowboysmall.scratch.cartrawler.model.CarResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cowboysmall.scratch.cartrawler.util.Filters.not;
import static com.cowboysmall.scratch.cartrawler.util.Statistics.calculateMedian;
import static java.util.Comparator.comparingDouble;
import static java.util.function.Function.identity;


public class CarResultProcessorImpl implements CarResultProcessor {

    private boolean filterMedian;


    //_________________________________________________________________________

    public CarResultProcessorImpl(boolean filterMedian) {

        this.filterMedian = filterMedian;
    }


    //_________________________________________________________________________

    @Override
    public List<CarResult> processCarResults(List<CarResult> carResults) {

        return partitionCarResults(
                carResults.stream()
                        .distinct()
                        .collect(Collectors.toList())
        ).collect(Collectors.toList());
    }


    //_________________________________________________________________________

    private Stream<CarResult> partitionCarResults(List<CarResult> carResults) {

        return Stream.concat(

                partitionCarResultsByGroup(
                        carResults.stream()
                                .filter(CarResult::isCorporate)
                                .collect(Collectors.toList())
                ),
                partitionCarResultsByGroup(
                        carResults.stream()
                                .filter(not(CarResult::isCorporate))
                                .collect(Collectors.toList())
                )
        );
    }

    private Stream<CarResult> partitionCarResultsByGroup(List<CarResult> carResults) {


        return Stream.of(

                sortCarResults(
                        carResults.stream()
                                .filter(CarResult::isMini)
                                .collect(Collectors.toList())
                ),
                sortCarResults(
                        carResults.stream()
                                .filter(CarResult::isEconomy)
                                .collect(Collectors.toList())
                ),
                sortCarResults(
                        carResults.stream()
                                .filter(CarResult::isCompact)
                                .collect(Collectors.toList())
                ),
                sortCarResults(
                        carResults.stream()
                                .filter(CarResult::isOther)
                                .collect(Collectors.toList())
                )

        ).flatMap(identity());
    }

    private Stream<CarResult> sortCarResults(List<CarResult> carResults) {


        Stream<CarResult> sorted =
                carResults.stream()
                        .sorted(comparingDouble(CarResult::getRentalCost));

        if (filterMedian) {

            List<CarResult> sortedList = sorted.collect(Collectors.toList());
            double median = calculateMedianRentalCost(sortedList);

            return sortedList.stream()
                    .filter(carResult -> isBelowMedian(carResult, median));

        } else {

            return sorted;
        }
    }


    //_________________________________________________________________________

    private double calculateMedianRentalCost(List<CarResult> carResults) {

        return calculateMedian(
                carResults.stream()
                        .map(CarResult::getRentalCost)
                        .collect(Collectors.toList())
        );
    }

    private boolean isBelowMedian(CarResult carResult, double median) {

        return carResult.isFuelPolicyFullEmpty() || carResult.getRentalCost() <= median;
    }
}
