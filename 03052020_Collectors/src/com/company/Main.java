package com.company;

import java.util.Arrays;
import java.util.List;
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
        Transaction tr02 = new Transaction("111-AA", 20000, 1122);
        Transaction tr03 = new Transaction("111-AA", 30000, 1122);
        Transaction tr04 = new Transaction("111-AA", 40000, 1212);

        Stream<Transaction> transactionStream = Stream.of(tr01, tr02, tr03, tr04);
        Map resultQty = transactionStream.collect(Collectors.groupingBy(Transaction::getUuid, Collectors.summingLong(Transaction::getSum)));
        System.out.println(resultQty.get("111-AA"));

        Account acc01 = new Account(-2000, false);
        Account acc02 = new Account(-20000, false);
        Account acc03 = new Account(-5000, false);
        Account acc04 = new Account(-1000, false);

        Stream<Account> bankStream = Stream.of(acc01, acc02, acc03, acc04);

        bankStream.filter(acc -> acc.getBalance() < -2000).forEach(account -> account.setLocked(true));
        System.out.println(acc02);

    }
}
