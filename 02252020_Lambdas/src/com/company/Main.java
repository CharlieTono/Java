package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

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
                x = x * (x + 1);
            }
            return x;
        };
        System.out.println(multiplication2.apply(1, 3));

        // Four example
        List<String> ourList = new ArrayList<>(Arrays.asList("Hello", "world", "Hello"));
        Function<List<String>, List<String>> filter = (List<String> list) -> new ArrayList<>(new HashSet<>(ourList));
        System.out.println(filter.apply(ourList));

//        Function<List<String>, List<String>> listOfString = oldList -> {
//            List<String> newList = new ArrayList<>();
//            for (int i = 0; i < oldList.size(); i++) {
//                if (!newList.contains(oldList.get(i))) {
//                    newList.add(oldList.get(i));
//                }
//            }
//            return newList;
//        };
//        System.out.println(listOfString.apply(ourList));

        // Five example
        Function<Integer, Integer> closureExample = x -> A * (x * x) + B * x + C;
        System.out.println(closureExample.apply(4));

        // Six example
        TernaryPredicate<Integer> isDifferent = (x, y, z) -> !x.equals(y) && !y.equals(z);
        System.out.println(isDifferent.test(1, 2, 3));

        // Seven example
        Function<Double, Double> f = x -> x * 2;
        Function<Double, Double> g = x -> x + 3;
        Function<Double, Double> h = f.compose(g);
        Function<Double, Double> j = g.compose(f);

        System.out.println(h.apply(5.));
        System.out.println(j.apply(2.));

        // Eight example

        Predicate<Integer> pre01 = x -> x > 0;
        Predicate<Integer> pre02 = x -> x < 0;

        Object o;
        List<Predicate<Integer>> listPredicate = new ArrayList<>(Arrays.asList(pre01, pre02));
        OurPredicate ourPredicate = new OurPredicate();
        System.out.println(ourPredicate.bulkOr(listPredicate).test(3));

        System.out.println(bulkOr(listPredicate).test(3));
    }

    static <T> Predicate<T> bulkOr(List<Predicate<T>> ourPredicates) {
        Predicate<T> result = t -> false;
        for (Predicate<T> predicate : ourPredicates) {
            result = result.or(predicate);
        }
        return result;
    }
}

class IdentityFunction<T> implements Function<T, T> {

    @Override
    public T apply(T t) {
        return t;
    }
}

