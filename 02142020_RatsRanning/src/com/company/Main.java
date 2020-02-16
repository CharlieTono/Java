package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int QTY_RUNNERS = 5;
    private static final int QTY_STEPS = 10;
    private static final int MIN_TIME = 0;
    private static final int MAX_TIME = 100;


    public static void main(String[] args) throws InterruptedException {
        List<FinishInfo> winRate = new ArrayList<>();
        List<Thread> runners = registeringRunners(winRate);
        start(runners);
        join(runners);

        System.out.println(winRate.toString());

        System.out.println("End of Rate");
    }

    private static List<Thread> registeringRunners(List<FinishInfo> winRate) {
        List<Thread> res = new ArrayList<>();
        for (int i = 1; i < QTY_RUNNERS + 1; i++) {
            Rat rat = new Rat(i, QTY_STEPS, MIN_TIME, MAX_TIME, winRate);
            Thread th = new Thread(rat);
            res.add(th);
        }
        return res;
    }

    private static void start(List<Thread> runners) {
        for (Thread thread : runners) {
            thread.start();
        }
    }

    private static void join(List<Thread> runners) throws InterruptedException {
        for (Thread thread : runners) {
            thread.join();
        }
    }
}
