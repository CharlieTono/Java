package com.company;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class DistinctCountingCollector implements Collector<LogEntry, HashSet<String>, Integer> {

    @Override
    public Supplier<HashSet<String>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<HashSet<String>, LogEntry> accumulator() {
        return (innerCollection, logEntry) -> innerCollection.add(logEntry.getUserName());
    }

    @Override
    public BinaryOperator<HashSet<String>> combiner() {
        return (innerCollection01, innerCollection02) -> {
            innerCollection01.addAll(innerCollection02);
            return innerCollection01;
        };
    }

    @Override
    public Function<HashSet<String>, Integer> finisher() {
        return HashSet::size;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
