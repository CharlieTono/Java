package com.company;

public class Main {

    public static void main(String[] args) {

        Interval interval = new Interval(11, 22);
        System.out.println(interval.qtyOfLovelyNumbers());
        System.out.println(interval.getLovelyNumbersBetween(2,11));

        Text text = new Text("It is the test text", 5);
        System.out.println(text.cutText());
        Text text02 = new Text();
        System.out.println(text02.crop("Test", 5));

    }
}
