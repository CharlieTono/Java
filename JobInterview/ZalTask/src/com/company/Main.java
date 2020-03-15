package com.company;

public class Main {

    public static void main(String[] args) {

        Interval interval = new Interval(11, 22);
        System.out.println(interval.qtyOfLovelyNumbers());

        Text text = new Text("It is the test text", 5);
        System.out.println(text.cutText());
    }
}
