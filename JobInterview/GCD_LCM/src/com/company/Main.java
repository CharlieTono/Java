package com.company;

public class Main {

    public static void main(String[] args) {

        int a = 100;
        int b = 20;

        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));

    }

    public static int gcd(int a, int b) { // the greatest common divisor (gcd)

        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int lcm(int a, int b) { // the least common multiple (lcm)

        return  (a * b) / gcd(a, b);
    }

}
