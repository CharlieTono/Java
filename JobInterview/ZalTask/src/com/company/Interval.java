package com.company;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Interval {

    private int x;
    private int y;


    public Interval(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long qtyOfLovelyNumbers() {
        IntStream newStream = IntStream.rangeClosed(x, y);
        return newStream.filter(this::isLovely).count();
    }

    private boolean isLovely(int i) {

        String number = String.valueOf(i);
        return number.chars().boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting())).values().stream().allMatch(x -> x >= 2);

    }
}
