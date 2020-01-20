package com.company.collection;

import com.company.comparator.OurComparator;

public class OurArrayList<E> implements List<E> {

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
    public void append(E o) {

        if (size == source.length) {
            Object[] newSource = new Object[size * 2];
            System.arraycopy(source, 0, newSource, 0, size);
            source = newSource;
        }
        source[size] = o;
        size++;
    }

    @Override
    public E get(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) source[index];
    }

    @Override
    public void set(E o, int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        source[index] = o;
    }

    @Override
    public E removeById(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        E removedObject = (E) source[index];
        System.arraycopy(source, index + 1, source, index, size - index);
        size--;
        return (E) removedObject;
    }

    @Override
    public boolean remove(E o) {

        for (int i = 0; i < size; i++) {
            if (source[i].equals(o)) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E o) {

        for (int i = 0; i < size; i++) {
            if (source[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E max(OurComparator<E> comparator) {
        if (size == 0) {
            throw new EmptyListException();
        }

        E max = (E) source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(max, (E) source[i]) < 0) {
                max = (E) source[i];
            }
        }
        return max;
    }

    @Override
    public E min(OurComparator<E> comparator) {
        if (size == 0) {
            throw new EmptyListException();
        }

        E min = (E) source[0];
        for (int i = 1; i < size; i++) {
            if (comparator.compare(min, (E) source[i]) > 0) {
                min = (E) source[i];
            }
        }
        return min;

//        return max(new OurComparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return -comparator.compare(o1, o2);
//            }
//        });

//        return max((o1, o2) -> -comparator.compare(o1, o2));
    }

    @Override
    public void sort(OurComparator<E> comparator) {

        Object temp = source[0];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare((E) source[j], (E) source[j + 1]) > 0) {
                    temp = (E) source[j];
                    source[j] = (E) source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
    }
}
