package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {8, 2, 6, 1, 9, 10, 5, 3, 7, 4};
        System.out.println(Arrays.toString(mergeSortStepDivision(array)));

    }

    public static int[] mergeSortStepDivision(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] arrayLeft = Arrays.copyOfRange(array, 0, middle);
        int[] arrayRight = Arrays.copyOfRange(array, middle, array.length);
        return mergeSort(mergeSortStepDivision(arrayLeft), mergeSortStepDivision(arrayRight));
    }

    public static int[] mergeSort(int[] arrayLeft, int[] arrayRight) {
        int arraySize = arrayLeft.length + arrayRight.length;
        int[] newArray = new int[arraySize];
        int indexFirst = 0;
        int indexSecond = 0;

        for (int i = 0; i < newArray.length; i++) {
            if (indexFirst == arrayLeft.length) {
                newArray[i] = arrayRight[indexSecond];
                indexSecond++;
            } else if (indexSecond == arrayRight.length) {
                newArray[i] = arrayLeft[indexFirst];
                indexFirst++;
            } else {
                if (arrayLeft[indexFirst] < arrayRight[indexSecond]) {
                    newArray[i] = arrayLeft[indexFirst];
                    indexFirst++;
                } else {
                    newArray[i] = arrayRight[indexSecond];
                    indexSecond++;
                }
            }
        }
        return newArray;
    }
}


