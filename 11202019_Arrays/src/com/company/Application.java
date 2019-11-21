package com.company;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        printRangeDown(100, 10, 10);

        int resultA = countArithmeticProgressionUp(1, 87, 1);
        System.out.println(resultA);

        int resultB = countArithmeticProgressionUp(5, 86, 3);
        System.out.println(resultB);

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        reverseArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println(sumEvenNumbers(array));
        System.out.println(containsOdd(array));
        System.out.println(Arrays.toString(countPositiveNumber(array)));
        printNumbers();
        System.out.println();

        int [] array02 = {0,2,4,5,6,7,10};
        int result01 = sumNumbersBeforeN(array02, 7);
        System.out.println(result01);
        int result02 = fibonacciNumbers(9);
        System.out.println(result02);
    }

    public static void printRangeDown(int first, int last, int step) {

        int number = first;
        while (number >= last) {
            System.out.print(number + " ");
            number -= step;
        }
        System.out.println();
    }

    public static int countArithmeticProgressionUp(int first, int last, int step) {

        int sum = 0;
        int number = first;

        while (number <= last) {
            sum += number;
            number += step;
        }
        return sum;
    }

    public static void reverseArray(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static boolean containsOdd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                return true;
            }
        }
        return false;
    }

    public static int sumEvenNumbers(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static int[] countPositiveNumber(int[] array) {
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                newArray[i] = array[i] * 3;
            } else {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }

    public static void printNumbers() {
        for (int i = 1; i <= 1000; i++) {
            if (i % 5 == 0 || i % 7 == 0 || i % 13 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static int sumNumbersBeforeN (int array [], int n) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1 && array [i] <= n) {
                sum += array [i];
            }
        }
        return sum;
    }

    public static int fibonacciNumbers (int n) {

        if (n <= 2) {
            return 1;
        }

        int left = 0;
        int right = 1;
        int fibonacci = 0;
        for (int i = 2; i < n; i++) {
            fibonacci = left + right;
            left = right;
            right = fibonacci;

        }
        return fibonacci;
    }


}
