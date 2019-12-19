package com.company;

import java.util.Random;

public class EvenNumbersRule implements RandomRule {

    @Override
    public int nextInt() {
        Random random = new Random();
        int number = random.nextInt();
        if (number % 2 == 0) {
            return number;
        } else {
            return number + 1;
        }
    }
}
