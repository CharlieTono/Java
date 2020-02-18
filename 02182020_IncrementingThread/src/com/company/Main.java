package com.company;

public class Main {

    private static final int THREADS_QTY = 1000;
    private static final int ITERATION_QTY = 10000;

    public static void main(String[] args) throws InterruptedException {

        Thread [] threads = new StaticIncrementingThread[THREADS_QTY];

        for (int i = 0; i < THREADS_QTY; i++) {
            Thread th = new StaticIncrementingThread(ITERATION_QTY);
            threads[i] = th;
        }

        for (int i = 0; i < THREADS_QTY; i++) {
            threads[i].start();
        }

        for (int i = 0; i < THREADS_QTY; i++) {
            threads[i].join();
        }

        System.out.println(StaticIncrementingThread.getCounter());
    }
}
