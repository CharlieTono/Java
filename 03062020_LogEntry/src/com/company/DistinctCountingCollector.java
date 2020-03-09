package com.company;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class DistinctCountingCollector<T> implements Collector<T, HashSet<T>, Integer> {

    @Override
    public Supplier<HashSet<T>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<HashSet<T>, T> accumulator() {
        return HashSet::add;
    }

    @Override
    public BinaryOperator<HashSet<T>> combiner() {
        return (innerCollection01, innerCollection02) -> {
            innerCollection01.addAll(innerCollection02);
            return innerCollection01;
        };
    }

    @Override
    public Function<HashSet<T>, Integer> finisher() {
        return HashSet::size;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
