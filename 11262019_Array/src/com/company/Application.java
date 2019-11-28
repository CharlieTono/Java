package com.company;

public class Application {

    public static void main(String[] args) {

        int[] javaArray = new int[]{18, 1, 10, 6, 2, 4, 7};

        Array ourArray = new Array(javaArray);
        System.out.println(ourArray.toString());

    }
}
