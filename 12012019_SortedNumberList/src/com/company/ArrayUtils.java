package com.company;

public class ArrayUtils {

    public static int[] copyArray(int[] array) {

        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static void bubbleSort(int[] array) {

        int temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static int binarySearch(int[] array, int number) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1; // int mid = (left + right) / 2;
            if (array[mid] < number) {
                left = mid + 1;
            } else if (array[mid] > number) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -(left + 1);
    }

    public static int[] insert(int[] array, int index, int value) {

        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }

        newArray[index] = value;

        for (int i = index + 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }

        return newArray;
    }

    public static int[] append(int[] array, int value) {  // return copy of array with a new element in the end

        int[] newArray = insert(array, array.length, value);

        return newArray;
    }
}
