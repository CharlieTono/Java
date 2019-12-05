package com.company.collection;

import java.util.Arrays;
import java.util.Objects;

public class OurArrayList extends List {

    Object[] source;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    OurArrayList() {
        source = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(Object o) {
        if (size < source.length) {
            source[size] = o;
            size++;
        }
    }

    @Override
    public Object get(int index) {

        for (int i = 0; i < size; i++) {
            if (i == index) {
                return source[i];
            }
        }
        return null;
    }

    @Override
    public void set(Object o, int index) {

        for (int i = 0; i < size; i++) {
            if (i == index) {
                source[i] = o;
            }
        }
    }

    @Override
    public Object removeById(int index) {

        Object removedObject;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                removedObject = source[i];
                source[i] = source[size - 1];
                size--;
                return removedObject;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (source[i].equals(o)) {
                source[i] = source[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OurArrayList)) return false;
        OurArrayList that = (OurArrayList) o;
        return size == that.size &&
                Arrays.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(source);
        return result;
    }
}
