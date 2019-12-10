package com.company.collection;

import com.company.comparator.OurComparator;

public class OurArrayList implements List {

    Object[] source;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public OurArrayList() {
        source = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(Object o) {

        if (size == source.length) {
            Object[] newSource = new Object[size * 2];
            System.arraycopy(source, 0, newSource, 0, size);
            source = newSource;
        }
        source[size] = o;
        size++;
    }

    @Override
    public Object get(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return source[index];
    }

    @Override
    public void set(Object o, int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        source[index] = o;
    }

    @Override
    public Object removeById(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object removedObject = source[index];
        System.arraycopy(source, index + 1, source, index, size - index);
        size--;
        return removedObject;
    }

    @Override
    public boolean remove(Object o) {

        for (int i = 0; i < size; i++) {
            if (source[i].equals(o)) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < size; i++) {
            if (source[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object max(OurComparator comparator) {
        Object max = source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(max, source[i]) < 0) {
                max = source[i];
            }
        }
        return max;
    }

    @Override
    public Object min(OurComparator comparator) {
        Object min = source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(min, source[i]) > 0) {
                min = source[i];
            }
        }
        return min;
    }

    @Override
    public void sort(OurComparator comparator) {

        Object temp = source[0];

        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (comparator.compare(source[j], source[j + 1]) > 0) {
                    temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
    }
}
