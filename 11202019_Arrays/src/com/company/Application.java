package com.company;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        printRangeDown(100,10,10);

        int resultA = countArithmeticProgressionUp(1,87,1);
        System.out.println(resultA);

        int resultB = countArithmeticProgressionUp(5, 86, 3);
        System.out.println(resultB);

        int [] array = {1,2,3,4,5,6,7,8,9,10};
        reverseArray(array);
        System.out.println(Arrays.toString(array));

    }

    public static void printRangeDown (int first, int last, int step) {

        int number = first;
        while (number >= last) {
            System.out.print(number + " ");
            number -= step;
        }
        System.out.println();
    }

    public static int countArithmeticProgressionUp (int first, int last, int step) {

        int sum = 0;
        int number = first;

        while (number <= last) {
            sum += number;
            number += step;
        }
        return sum;
    }

    public static void reverseArray (int [] array) {

        for (int i = 0; i < array.length/2; i++) {
            int temp = array [i];
            array[i] = array [array.length-i-1];
            array[array.length-i-1] = temp;
        }
    }
}
