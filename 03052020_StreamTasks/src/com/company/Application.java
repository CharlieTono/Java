package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        Transaction tr01 = new Transaction(State.CANCELED, 10000);
        Transaction tr02 = new Transaction(State.PROCESSING, 10000);
        Transaction tr03 = new Transaction(State.PROCESSING, 10000);
        Transaction tr04 = new Transaction(State.CANCELED, 10000);
        Transaction tr05 = new Transaction(State.FINISHED, 10000);
        Transaction tr06 = new Transaction(State.FINISHED, 10000);
        Transaction tr07 = new Transaction(State.CANCELED, 10000);
        Transaction tr08 = new Transaction(State.FINISHED, 10000);
        Transaction tr09 = new Transaction(State.PROCESSING, 10000);

        Account acc01 = new Account(500, Arrays.asList(tr01, tr02, tr03));
        Account acc02 = new Account(-500, Arrays.asList(tr04, tr05, tr06));
        Account acc03 = new Account(1, Arrays.asList(tr07, tr08, tr09));

        Stream<Account> accountStream = Stream.of(acc01, acc02, acc03);

        long res = accountStream.filter(acc -> acc.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELED)
                .mapToLong(Transaction::getSum)
                .sum();

        System.out.println(res);
        
        long res02 = accountStream.filter(acc -> acc.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELED)
                .collect(Collectors.reducing(0L, Transaction:: getSum, (currentResult, currentElt) -> currentElt+currentResult));

        System.out.println(res02);
    }
}
