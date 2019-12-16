package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(fibonacciNumbers(3));
    }

    public static int fibonacciNumbers(int n) {

        int left = 1;
        int right = 1;
        int fibonacci = 0;

        if (n < 2) {
            return n;
        }

        for (int i = 2; i < n; i++) {
            fibonacci = left + right;
            left = right;
            right = fibonacci;
        }
        return right;
    }
}
