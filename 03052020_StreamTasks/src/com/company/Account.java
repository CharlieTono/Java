package com.company;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    private static AtomicInteger incrementer = new AtomicInteger();

    private int number;
    private long balance;
    private List<Transaction> transactions;

    public Account(long balance, List<Transaction> transactions) {
        this.number = incrementer.addAndGet(1);
        this.balance = balance;
        this.transactions = transactions;
    }

    public int getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
