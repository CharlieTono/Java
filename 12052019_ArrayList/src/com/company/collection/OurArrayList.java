package com.company.collection;

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
}
