package com.company;

import java.util.List;

public class PersonFirst extends Employee {

    private String name;
    private int loan;
    private int min;
    private int max;
    private double velocity = 1.2;

    List<FinishInfo> winRate;

    public PersonFirst(String name, int loan, int min, int max, List<FinishInfo> winRate) {
        this.name = name;
        this.loan = loan;
        this.min = min;
        this.max = max;
        this.winRate = winRate;
    }

    @Override
    public void run() {

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < loan; i++) {
            try {
                Thread.sleep((long)velocity*max / (long)velocity*min);
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println(name + " has finished");
        FinishInfo info = new FinishInfo(name, System.currentTimeMillis() - currentTime);
        winRate.add(info);

    }
}
