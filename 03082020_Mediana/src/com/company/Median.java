package com.company;

import java.util.List;

public class Median {

    private List<Integer> numbers;

    public Median(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Double defineAMedian() {
        Double median = numbers.stream().collect(new MedianCollector());
        return median;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
