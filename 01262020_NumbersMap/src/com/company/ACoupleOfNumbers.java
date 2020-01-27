package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ACoupleOfNumbers {

    public int findSingleNumber(List<Integer> list) {

        int result = 0;

        Map<Integer, Integer> ourMap = new HashMap<>();

        for (int number : list) {
            if (ourMap.containsKey(number)) {
                int counter = ourMap.get(number);
                counter++;
                ourMap.put(number, counter);
            } else {
                ourMap.put(number, 1);
            }
        }

        for (int i : ourMap.keySet()) {
            if (ourMap.get(i) % 2 == 1) {
                result = i;
            }
        }
        return result;
    }
}
