package com.company;

import java.util.Random;

public class MinMaxRule implements RandomRule {

    int max;
    int min;

    public MinMaxRule(int min, int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public int nextInt() {
        Random random = new Random();
        int number = min + random.nextInt(max - min);
        return number;
    }

}
