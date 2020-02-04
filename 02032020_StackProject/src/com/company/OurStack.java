package com.company;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class OurStack<E> {

    private Deque<E> source;
    private Deque<E> sourceMax;
    private Comparator<E> comparator;

    public OurStack(Comparator<E> comparator) {
        source = new ArrayDeque<>();
        sourceMax = new ArrayDeque<>();
        this.comparator = comparator;
    }

    public OurStack() {
        source = new ArrayDeque<>();
        sourceMax = new ArrayDeque<>();
        this.comparator = new ComparatorComparable<>();
    }

    public int getSize() {
        return source.size();
    }

    public void addLast(E element) {

        source.addLast(element);
        if (sourceMax.size() == 0 || comparator.compare(element, sourceMax.getLast()) > 0) {
            sourceMax.addLast(element);
        } else {
            sourceMax.addLast(sourceMax.getLast());
        }
    }

    public E removeLast() {
        E element = source.removeLast();
        sourceMax.removeLast();
        return element;
    }

    public E getLast() {
        E element = source.getLast();
        return (E) element;
    }

    public E getMax() {

        E element = sourceMax.getLast();
        return element;
    }

    class ComparatorComparable<E> implements Comparator<E> {

        @Override
        public int compare(E o1, E o2) {
            Comparable o1comparable = (Comparable) o1;
            return o1comparable.compareTo(o2);
        }
    }
}


