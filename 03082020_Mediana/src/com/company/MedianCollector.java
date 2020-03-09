package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MedianCollector implements Collector<Integer, ArrayList<Integer>, Double> {
    @Override
    public Supplier<ArrayList<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<Integer>, Integer> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<Integer>> combiner() {
        return (innerCollection01, innerCollection02) -> {
            innerCollection01.addAll(innerCollection02);
            return innerCollection01;
        };
    }

    @Override
    public Function<ArrayList<Integer>, Double> finisher() {
        return (innerCollection01) -> {
            Collections.sort(innerCollection01);
            if (innerCollection01.size() % 2 == 0) {
                return ((double) innerCollection01.get(innerCollection01.size() / 2 - 1) + innerCollection01.get(innerCollection01.size() / 2)) * 0.5;
            } else {
                return (double) innerCollection01.get(innerCollection01.size() / 2);
            }
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
