package com.company;

import java.util.ArrayList;
import java.util.List;

public class OurStack {

    List<Integer> source = new ArrayList<>();
    List<Integer> sourceMax = new ArrayList<>();

    private int getSize() {
        return source.size();
    }

    private void addLast(int element) {

        source.add(element);
        if (sourceMax.size() == 0 || element > sourceMax.get(source.size() - 1)) {
            sourceMax.add(element);
        } else {
            sourceMax.add(sourceMax.get(sourceMax.size() - 1));
        }
    }

    private Integer removeLast() {
        Integer element = source.remove(source.size() - 1);
        sourceMax.remove(source.size() - 1);
        return element;
    }

    private Integer getLast() {
        Integer element = source.get(getSize() - 1);
        return element;
    }

    private Integer getMax() {

        Integer element = sourceMax.get(sourceMax.size() - 1);
        return element;
    }

}
