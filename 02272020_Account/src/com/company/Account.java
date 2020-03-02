package com.company;

public class Account {
    private String number;
    private long balance;
    private boolean isBlocked;

    public Account(String number, long balance, boolean isBlocked) {
        this.number = number;
        this.balance = balance;
        this.isBlocked = isBlocked;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    @Override
    public String toString() {
        return "Account: " + number + '\n' +
                "balance: " + balance + "\n" +
                "block info: " + isBlocked + "\n";
    }
}
