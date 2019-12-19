package com.company;

import java.util.Random;

public class MinMaxRule implements RandomRule {

    Random random = new Random();

    int max;
    int min;

    public MinMaxRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int nextInt() {
        return (int) (min + Math.abs(random.nextLong()) % ((long) max - min));
    }

}
