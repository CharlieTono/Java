package com.company;

public class Main {

    public static void main(String[] args) {

        int sum = 9;
        System.out.println(countCoins(sum));
    }

    public static int countCoins(int sum) { // coins 10 / 5 / 1
        int counter = 0;
        counter = sum / 10;
        sum = sum % 10;
        counter = counter + (sum / 5);
        sum = sum % 5;
        counter = counter + sum;
        return counter;
    }
}
