package com.company;

import java.util.List;

public class PersonThrid extends Employee {

    private String name;
    private int loan;
    private int min;
    private int max;
    private double velocity = 1.5;

    List<FinishInfo> winRate;

    public PersonThrid(String name, int loan, int min, int max, List<FinishInfo> winRate) {
        this.name = name;
        this.loan = loan;
        this.min = min;
        this.max = max;
        this.winRate = winRate;
    }

    @Override
    public void run() {

        boolean coffeeShot = false;
        int counter = 0;

        long currentTime = System.currentTimeMillis();

        for (int i = 1; i < loan + 1; i++) {

            if (i % 5 == 0) {
                coffeeShot = true;
                counter = 0;
            }

            if (coffeeShot && counter < 3) {
                try {
                    Thread.sleep((long) velocity * max / (long) velocity * min);
                } catch (InterruptedException e) {
                    return;
                }
                counter++;
            } else {
                coffeeShot = false;
                try {
                    Thread.sleep(max - min);
                } catch (InterruptedException e) {
                    return;
                }
            }

        }
        System.out.println(name + " has finished");
        FinishInfo info = new FinishInfo(name, System.currentTimeMillis() - currentTime);
        winRate.add(info);

    }
}
