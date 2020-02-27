package com.company;

import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    final static Integer A = 1;
    final static Integer B = 2;
    final static Integer C = 3;

    public static void main(String[] args) {

        // First example
        Function<Integer, Integer> identity = x -> x;
        Function<Integer, Integer> identity2 = new IdentityFunction<>();

        System.out.println(identity.apply(5));
        System.out.println(identity2.apply(7));

        // Second example
        BiFunction<Integer, Integer, Integer> multiplication = (x, y) -> x * y;
        System.out.println(multiplication.apply(5, 2));

        // Third example
        BiFunction<Integer, Integer, Integer> multiplication2 = (x, y) -> {
            for (int i = x; i < y; i++) {
                x = x*(x+1);
            }
            return x;
        };
        System.out.println(multiplication2.apply(1, 3));

        // Four example
        List<String> ourList = new ArrayList<>(Arrays.asList("Hello", "world", "Hello"));

        Function<List<String>, List<String>> listOfString = oldList -> {
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < oldList.size(); i++) {
                if (!newList.contains(oldList.get(i))) {
                    newList.add(oldList.get(i));
                }
            }
            return newList;
        };
        System.out.println(listOfString.apply(ourList));

        // Five example
        Function<Integer, Integer> closureExample = x -> A*(x*x)+B*x+C;
        System.out.println(closureExample.apply(4));

    }
}

class IdentityFunction<T, R> implements Function<T, T> {

    @Override
    public T apply(T t) {
        return t;
    }
}
