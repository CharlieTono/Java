package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Account client01 = new Account("AA1010", 100000, true);
        Account client02 = new Account("BB1010", 1000000, false);
        Account client03 = new Account("CC1010", 0, true);
        Account client04 = new Account("DD1010", 200, false);

        List<Account> clients = new ArrayList<>(Arrays.asList(client01, client02, client03, client04));

        Predicate<Account> isBalanceMoreThanZero = answer -> answer.getBalance() > 0;
        Predicate<Account> isBlocked = Account::isBlocked;

        Predicate<Account> isCreditApproved = isBlocked.negate().and(isBalanceMoreThanZero);

        AccFilter filter = new AccFilter();
        System.out.println(filter.filter(clients, isCreditApproved));

    }
}
