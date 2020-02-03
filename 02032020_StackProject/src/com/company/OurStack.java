package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OurStack<E> implements Comparator<E> {

    public OurStack(List<E> source, List<E> sourceMax) {
        this.source = source;
        this.sourceMax = sourceMax;
    }

    List<E> source = new ArrayList<>();
    List<E> sourceMax = new ArrayList<>();
    Comparator<E> comparator;

    private int getSize() {
        return source.size();
    }

    private void addLast(E element) {

        source.add(element);
        if (sourceMax.size() == 0 || comparator.compare(element, getMax()) < 0) {
            sourceMax.add(element);
        } else {
            sourceMax.add(sourceMax.get(sourceMax.size() - 1));
        }
    }

    private E removeLast() {
        E element = source.remove(source.size() - 1);
        sourceMax.remove(source.size() - 1);
        return element;
    }

    private E getLast() {
        E element = source.get(getSize() - 1);
        return (E) element;
    }

    @Override
    public int compare(E o1, E o2) {

        Integer left = (Integer) o1;
        Integer right = (Integer) o2;

        if (left < right) {
            return -1;
        }
        if (left > right) {
            return 1;
        }
        return 0;
    }

    public E getMax() {

        E element = sourceMax.get(sourceMax.size() - 1);
        return element;
    }
}
