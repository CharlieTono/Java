package com.company;

public class ArrayUtils {

    public static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static int[] sortArray(int[] array) { //bubble sort

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
        return array;
    }

    public static int binarySearch(int[] array, int number) {

        int left = 0;
        int right = array.length - 1;
        boolean flag = true;

        do {
            int mid = (left + right) / 2;
            if (array[mid] > number) {
                right = mid - 1;
            } else if (array[mid] < number){
                left = mid + 1;
                flag = false;
            } else {
                return mid;
            }
        } while (left <= right);

        if (flag) {
            return -(right+1);
        } else {
            return -(left+1);
        }
    }

    public static int[] append(int[] array, int value) {  // return copy of array with a new element in the end
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i]= array[i];
        }
        newArray[newArray.length - 1] = value;
        return newArray;
    }

    public static int[] insert(int[] array, int index, int value) {

        int[] newArray = append(array, value);

        for (int i = index; i < newArray.length; i++) {
            int temp = newArray[i];
            newArray[i] = newArray[newArray.length-1];
            newArray[newArray.length-1] = temp;
        }
        return newArray;
    }
}
