package com.company;

public class Main {

    private static final int THREADS_QTY = 100;
    private static final int ITERATION_QTY = 100000;

    public static void main(String[] args) throws InterruptedException {

        Incrementer incrementer = new Incrementer();
        Thread[] threads = new IncrementingThread[THREADS_QTY];

        for (int i = 0; i < THREADS_QTY; i++) {
            Thread th = new IncrementingThread(incrementer, ITERATION_QTY);
            threads[i] = th;
        }

        for (int i = 0; i < THREADS_QTY; i++) {
            threads[i].start();
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < THREADS_QTY; i++) {
            threads[i].join();
        }

        long finishTime = System.currentTimeMillis();

        System.out.println(finishTime-startTime);
        System.out.println(incrementer.getCounter());
        System.out.println(incrementer.getCounter2());
    }
}
