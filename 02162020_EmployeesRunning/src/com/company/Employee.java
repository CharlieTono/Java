package com.company;

import java.util.Random;

public abstract class Employee implements Runnable {

    protected String name;
    protected int loan;
    protected int min;
    protected int max;
    protected long finishTime;

    protected Random random = new Random();

    public Employee(String name, int loan, int min, int max) {
        this.name = name;
        this.loan = loan;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public long getFinishTime() {
        return finishTime;
    }
}
