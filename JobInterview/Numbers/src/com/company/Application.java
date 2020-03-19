package com.company;

public class Application {

    public static void main(String[] args) {
        int sum = 10;
        System.out.println(breakingNumber(sum));
    }

    public static int breakingNumber(int sum) {
        int counter = 0;
        int number = 1;

        while (sum != 0 && sum >= number) {
            if (sum / number > 1 || sum == number) {
                sum = sum - number;
                number++;
                counter++;
            } else {
                number++;
            }
        }
        return counter;
    }
}
