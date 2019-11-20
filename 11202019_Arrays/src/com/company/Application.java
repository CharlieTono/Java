package com.company;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        printArray();
        System.out.println();
        System.out.println(countArithmeticProgression());
        System.out.println(countMod3());

        int [] array = {1,2,3,4,5,6,7,8,9,10};
        reverseArray(array);
        System.out.println(Arrays.toString(array));

    }

    public static void printArray () {
        for (int i = 100; i > 1; i=i-10) {
            System.out.print(i + " ");
        }
    }

    public static int countArithmeticProgression () {
        int result = 0;

        for (int i = 1; i < 88; i++) {
            result += i;
        }

        return result;
    }

    public static int countMod3 () {
        int result = 0;

        for (int i = 2; i < 87; i=i+3) {
            result += i;
        }

        return result;
    }

    public static int [] reverseArray (int [] array) {
        int temp = array[0];
        array[0] = array [array.length-1];
        array[array.length-1] = temp;

        for (int i = 1; i < array.length/2; i++) {
            temp = array [i];
            array [i] = array[array.length-i-1];
            array [array.length-i-1] = temp;
        }
        return array;
    }
}
