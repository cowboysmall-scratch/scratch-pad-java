package com.cowboysmall.scratch.cartrawler.component;

import com.cowboysmall.scratch.cartrawler.model.CarResult;
import com.cowboysmall.scratch.cartrawler.model.Type;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Map<Boolean, List<CarResult>> partitioned =
                carResults.stream()
                        .collect(Collectors.partitioningBy(CarResult::isCorporate));

        return Stream.concat(

                partitionCarResultsByGroup(partitioned.get(true)),
                partitionCarResultsByGroup(partitioned.get(false))
        );
    }

    private Stream<CarResult> partitionCarResultsByGroup(List<CarResult> carResults) {

        Map<Type, List<CarResult>> grouped =
                carResults.stream()
                        .collect(Collectors.groupingBy(CarResult::getType));

        return Stream.of(

                sortCarResults(grouped.get(Type.MINI)),
                sortCarResults(grouped.get(Type.ECONOMY)),
                sortCarResults(grouped.get(Type.COMPACT)),
                sortCarResults(grouped.get(Type.OTHER))

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
