package com.company;

public class Transaction {

    private String uuid;
    private long sum;
    private int accId;

    public Transaction(String uuid, long sum, int accId) {
        this.uuid = uuid;
        this.sum = sum;
        this.accId = accId;
    }

    public String getUuid() {
        return uuid;
    }

    public long getSum() {
        return sum;
    }

    public int getAccId() {
        return accId;
    }
}
