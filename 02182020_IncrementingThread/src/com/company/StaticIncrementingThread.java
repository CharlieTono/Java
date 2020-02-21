package com.company;

public class StaticIncrementingThread extends Thread {

    private int incrementsNumber;
    private static int counter;
    private static final Object mutex = new Object();

    public static int getCounter() {
        return counter;
    }

    public StaticIncrementingThread(int incrementsNumber) {
        this.incrementsNumber = incrementsNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementsNumber; i++) {
            synchronized (mutex) {
                counter++;
            }
        }
    }
}
