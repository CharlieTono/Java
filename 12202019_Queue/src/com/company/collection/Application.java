package com.company.collection;

public class Application {

    public static void main(String[] args) {

        ArrayQueue<Integer> intsQueue = new ArrayQueue(5);
        intsQueue.add(5);
        intsQueue.add(10);
        intsQueue.add(15);

        for (Integer num : intsQueue) {
            System.out.println(num);
        }

    }
}
