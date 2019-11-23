package com.company;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        int[][] array1 = new int[10][10];
        int[][] array2 = new int[][]{{0, 1, 2}, {-3, -4, -5}, {6, 7, 8}}; // max length is 255
        int[][] array3 = new int[10][10];
        int[][] array4 = new int[8][8];
        System.out.println(countUnderArray(array2));
        array1 = fillArray();
        System.out.println(Arrays.toString(array1));
        array3 = fillArray2();
        System.out.println(Arrays.toString(array3));
        array4 = fillArray3();
        System.out.println(Arrays.toString((array4)));
        System.out.println(countPositiveArrayOnly(array2));
    }

    public static int countUnderArray(int array[][]) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public static int[][] fillArray() {
        int counter = 0;

        int array[][] = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = counter;
                counter++;
            }
            System.out.println(Arrays.toString(array[i]));
        }
        return array;
    }

    public static int[][] fillArray2() {
        int array[][] = new int[10][10];

        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < array.length; j++) {
                array[i][array.length - j - 1] = i * 10 + j;
            }
            System.out.println(Arrays.toString(array[i]));
        }
        return array;
    }

    public static int[][] fillArray3() {

        int array[][] = new int[8][8];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((i+j)%2 ==0 ) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(array[i]));
        }
        return array;
    }

    public static int countPositiveArrayOnly(int [][] array) {
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] <= 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                counter++;
            }
        }
        return counter;
    }
}
