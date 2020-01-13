package com.company.collection;

import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>, Iterable<E> {

    private int size;
    private int capacity;
    private int first;
    private Object[] source;

    ArrayQueue(int capacity) {
        this.capacity = capacity;
        source = new Object[capacity];
    }

    @Override
    public void add(E e) {
        if (size == capacity) {
            throw new QueueOverflowException();
        }
        int index = (first + size) % capacity;
        source[index] = e;
        size++;
    }

    @Override
    public E release() {

        if (size == 0) {
            throw new QueueEmptyException();
        }
        int index = (first + size) % capacity;
        E result = (E) source[index];
        source[index] = null;
        first = index;
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new OurArrayQueueIterator();
    }

    class OurArrayQueueIterator implements Iterator<E> {
        int currentId = 0;

        @Override
        public boolean hasNext() {
            if (currentId < size) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public E next() {
            int index = (first + currentId) % capacity;
            E result = (E) source[index];
            currentId++;
            return result;
        }
    }
}


