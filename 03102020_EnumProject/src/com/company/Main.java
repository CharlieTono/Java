package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(TransactionState.CANCELLED.name());
        System.out.println(TransactionState.CANCELLED.ordinal());
        System.out.println(TransactionState.CANCELLED.toString());

        Arrays.stream(TransactionState.values()).forEach(System.out::println);
        System.out.println(Calculator.SUM.action(4, 5));

        System.out.println(Color.BLUE.getCode());

    }
}
