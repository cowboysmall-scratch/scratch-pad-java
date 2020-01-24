package com.cowboysmall.scratch.cartrawler.component;

import com.cowboysmall.scratch.cartrawler.model.CarResult;

import java.util.List;

public interface CarResultProcessor {

    List<CarResult> processCarResults(List<CarResult> carResults);
}
