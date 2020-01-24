package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 3, 8, 8, -20, 8);
        System.out.println(checkRepeatedNumber(list));

    }

    public static int checkRepeatedNumber(List<Integer> list) {
        int result = 0;
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i : list) {
            if (numbers.containsKey(i)) {
                int counter = numbers.get(i);
                counter++;
                numbers.put(i, counter);
            } else {
                numbers.put(i, 1);
            }
        }

        for (int i : numbers.keySet()) {
            if (numbers.get(i) > 1) {
                result++;
            }
        }
        return result;
    }

}
