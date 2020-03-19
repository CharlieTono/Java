package com.company;

public class Application {

    public static void main(String[] args) {

        System.out.println(fibonacciExcess(5, 2));
    }

    public static int fibonacciExcess(int n, int m) {

        int left = 1;
        int right = 1;
        int fibonacci = 0;
        int excess = 0;

        if (n < 2) {
            return n % m;
        }

        for (int i = 2; i < n; i++) {
            fibonacci = left + right;
            left = right;
            right = fibonacci;
            excess = (right + left) % m;
        }
        return excess;
    }
}
