package com.company;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> identity = x -> x;
        Function<Integer, Integer> identity2 = new IdentityFunction<>();

        System.out.println(identity.apply(5));
        System.out.println(identity2.apply(7));

        BiFunction<Integer, Integer, Integer> multiplication = (x, y) -> x * y;
        System.out.println(multiplication.apply(5, 2));

        BiFunction<Integer, Integer, Integer> multiplication2 = (x, y) -> {
            for (int i = x; i < y; i++) {
                x = x*(x+1);
            }
            return x;
        };
        System.out.println(multiplication2.apply(1, 3));
    }
}

class IdentityFunction<T, R> implements Function<T, T> {

    @Override
    public T apply(T t) {
        return t;
    }
}
