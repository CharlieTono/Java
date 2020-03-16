package com.company;

import java.util.List;
import java.util.function.Function;
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

    /**
     * get all the 'lovely' numbers in the specified range
     * @param a the first number in the range
     * @param b the largest number in the range
     * @return List of all lovely numbers
     */
    public List<Integer> getLovelyNumbersBetween(int a, int b) {
        return IntStream.rangeClosed(a, b).filter(this::isLovelySecond).boxed().collect(Collectors.toList());
    }

    private boolean isLovelySecond(int i) {
        return String.valueOf(i)
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .noneMatch(x -> x > 2);
    }
}
