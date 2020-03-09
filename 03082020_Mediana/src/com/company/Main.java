package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(-5, 10, 5, 1, 0, -3);
        Median median = new Median(numbers);
        System.out.println(median.defineAMedian());
    }
}
