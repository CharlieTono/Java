package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(recursiveFactorial(5));

    }

    public static int recursiveFactorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * recursiveFactorial(n - 1);
        }
    }

}
