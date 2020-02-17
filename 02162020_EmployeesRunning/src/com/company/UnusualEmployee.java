package com.company;

public class UnusualEmployee extends Employee {

    private static int INSPIRATION = 20;
    private static int INSPIRATION_TIMES = 3;
    private double inspirationCoef;

    public UnusualEmployee(String name, int loan, int min, int max, double inspirationCoef) {
        super(name, loan, min, max);
        this.inspirationCoef = inspirationCoef;
    }

    @Override
    public void run() {

        int counter = 0;

        for (int i = 0; i < loan; i++) {
            int timeToSleep;

            if (counter == 0 && random.nextInt(100) < INSPIRATION) {
                counter = INSPIRATION_TIMES;
            }

            if (counter > 0) {
                timeToSleep = (int) ((min + random.nextInt(max - min)) / inspirationCoef);
                counter--;
            } else {
                timeToSleep = min + random.nextInt(max - min);
            }

            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                return;
            }
        }
        finishTime = System.currentTimeMillis();
    }
}
