package com.company;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<Integer> sqrStream = Stream.of(1, 2, 3);
        int resultSum = sqrStream.collect(Collectors.summingInt(n -> Integer.valueOf(n * n)));
        System.out.println(resultSum);

        Stream<String> palindromeStream = Stream.of("lol", "max", "non", "min");
        Map resultMap = palindromeStream.collect(Collectors.partitioningBy(word -> {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            return sb.toString().equals(word);
        }));
        System.out.println(resultMap.get(true));

        Transaction tr01 = new Transaction("111-AA", 10000, 1212);
        Transaction tr02 = new Transaction("111-AB", 20000, 1122);
        Transaction tr03 = new Transaction("111-BA", 30000, 2211);
        Transaction tr04 = new Transaction("111-BB", 40000, 2121);

        Stream<Transaction> transactionStream = Stream.of(tr01, tr02, tr03, tr04);
        long resultQty = transactionStream.collect(Collectors.counting());
        System.out.println(resultQty);

    }
}
