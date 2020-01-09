package com.company.collection;

public interface Queue<E> {

    public void add(E e);

    public E release();

    public int size();

    public int capacity();
}
