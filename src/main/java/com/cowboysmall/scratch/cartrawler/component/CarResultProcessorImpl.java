package com.cowboysmall.scratch.cartrawler.component;

import com.cowboysmall.scratch.cartrawler.model.CarResult;
import com.cowboysmall.scratch.cartrawler.model.Type;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.cowboysmall.scratch.cartrawler.util.Statistics.calculateMedian;
import static java.util.Collections.emptyList;
import static java.util.Comparator.comparingDouble;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;


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
                        .collect(toList())
        ).collect(toList());
    }


    //_________________________________________________________________________

    private Stream<CarResult> partitionCarResults(List<CarResult> carResults) {

        Map<Boolean, List<CarResult>> partitioned =
                carResults.stream()
                        .collect(partitioningBy(CarResult::isCorporate));

        return Stream.concat(

                partitionCarResultsByGroup(partitioned.get(true)),
                partitionCarResultsByGroup(partitioned.get(false))
        );
    }

    private Stream<CarResult> partitionCarResultsByGroup(List<CarResult> carResults) {

        Map<Type, List<CarResult>> grouped =
                carResults.stream()
                        .collect(groupingBy(CarResult::getType));

        return Stream.of(

                sortCarResults(grouped.getOrDefault(Type.MINI, emptyList())),
                sortCarResults(grouped.getOrDefault(Type.ECONOMY, emptyList())),
                sortCarResults(grouped.getOrDefault(Type.COMPACT, emptyList())),
                sortCarResults(grouped.getOrDefault(Type.OTHER, emptyList()))

        ).flatMap(identity());
    }

    private Stream<CarResult> sortCarResults(List<CarResult> carResults) {


        Stream<CarResult> sorted =
                carResults.stream()
                        .sorted(comparingDouble(CarResult::getRentalCost));

        if (filterMedian) {

            List<CarResult> sortedList = sorted.collect(toList());

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
                        .collect(toList())
        );
    }

    private boolean isBelowMedian(CarResult carResult, double median) {

        return carResult.isFuelPolicyFullEmpty() || carResult.getRentalCost() <= median;
    }
}
