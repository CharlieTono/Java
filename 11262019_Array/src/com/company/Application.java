package com.company;

import java.util.Arrays;

import static com.company.ArrayUtils.*;

public class Application {

    public static void main(String[] args) {

        int [] javaArray = new int [] {8, 1, 3, 6, 2, 4, 7};
        Array ourArray = new Array(new int [] {1, 3, -8, 5});

        int a1 = javaArray[0]; //1
        int a2 = ourArray.get(0); //1

        //System.out.println(Arrays.toString(copyArray(javaArray)));
        System.out.println(Arrays.toString(sortArray(javaArray)));
        System.out.println(binarySearch(javaArray, 2));
        //System.out.println(Arrays.toString(append(javaArray, 9)));
        //System.out.println(Arrays.toString(insert(javaArray, 4, 5)));

    }
}
