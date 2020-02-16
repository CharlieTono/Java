package com.company;

import java.util.List;
import java.util.Random;

public class Rat implements Runnable {

    private int id;
    private int step;
    private int min;
    private int max;
    List<FinishInfo> winRate;

    private Random random = new Random();

    public Rat(int id, int step, int min, int max, List<FinishInfo> winRate) {
        this.id = id;
        this.step = step;
        this.min = min;
        this.max = max;
        this.winRate = winRate;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < step; i++) {
            try {
                Thread.sleep(min + random.nextInt(max - min));
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("Rat " + id + "is finished");
        FinishInfo info = new FinishInfo(id, System.currentTimeMillis() - currentTime);
        winRate.add(info);
    }
}
