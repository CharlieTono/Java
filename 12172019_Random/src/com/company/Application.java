package com.company;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        RandomRule rule01 = new MinMaxRule(0,30);
        RandomRule rule02 = new EvenNumbersRule();

        RandomGenerator generator01 = new RandomGenerator(rule01);
        RandomGenerator generator02 = new RandomGenerator(rule02);

        System.out.println(Arrays.toString(generator01.nextInts(10)));
        System.out.println(Arrays.toString(generator02.nextInts(10)));

    }
}
