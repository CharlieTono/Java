package com.company;

public class Recursion {

    public int square(int n) {

        if (n > 0)
            return square(n - 1) + n + (n - 1);
        return n;
    }

    public int power(int n, int k) {

        if (k == 0) {
            return 1;
        } else {
            return n * power(n, k - 1);
        }
    }

    public int sumOfIntegers(int n) {
        int result = 0;
        if (result == n) {
            return result;
        } else {
            return result = n + sumOfIntegers(n - 1);
        }
    }

    public int sumOfIntegers2(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + sumOfIntegers2(n / 10);
        }
    }

    public void compareOfIntegers(int a, int b) {

        if (a == b) {
            System.out.print(a + " ");
        } else if (a < b) {
            compareOfIntegers(a, b - 1);
            System.out.print(b + " ");
        } else {
            compareOfIntegers(a, b + 1);
            System.out.println(b + " ");
        }
    }
}

