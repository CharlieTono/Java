package com.company.collection;

import java.util.Iterator;

public class OurArrayListIterator<E> implements Iterator<E> {

    private OurArrayOurList<E> list;
    int currentId = 0;

    public OurArrayListIterator(OurArrayOurList<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentId < list.size();
    }

    @Override
    public E next() {
        return list.get(currentId++);
    }
}
