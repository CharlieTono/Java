package com.company;

public class Account {

    private long balance;
    private boolean isLocked;

    public Account(long balance, boolean isLocked) {
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "Account: " +
                "balance: " + balance + ", isLocked: " + isLocked;
    }
}
