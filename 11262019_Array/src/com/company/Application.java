package com.company;

import java.util.Arrays;

import static com.company.ArrayUtils.*;

public class Application {

    public static void main(String[] args) {

        int [] javaArray = new int [] {18, 1, 10, 6, 2, 4, 7};
        Array ourArray = new Array(new int [] {1, 3, -8, 5});

        int a1 = javaArray[0];
        int a2 = ourArray.get(0);

        System.out.println(Arrays.toString(copyArray(javaArray)));
        ArrayUtils.selectionSort(javaArray);
        System.out.println(Arrays.toString(javaArray));
        System.out.println(binarySearch(javaArray, -3));
        System.out.println(Arrays.toString(append(javaArray, 9)));
        System.out.println(Arrays.toString(insert(javaArray, 3, 5)));

    }
}
