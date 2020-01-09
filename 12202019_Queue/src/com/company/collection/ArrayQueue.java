package com.company.collection;

public class ArrayQueue<E> implements Queue<E> {

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
}
