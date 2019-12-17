package com.company;

public class RandomGenerator {

    RandomRule rule;

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }

    public int [] nextInts (int n) {

        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rule.nextInt();
        }
        return array;
    }
}
