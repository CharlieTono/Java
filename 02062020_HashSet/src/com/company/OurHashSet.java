package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OurHashSet<E> extends OurAbstractSet<E> {

    final static Object INSTANCE = new Object();
    private Map<E, Object> source;

    public OurHashSet() {
        this.source = new HashMap<>();
    }

    @Override
    public boolean add(E elt) {
        return source.put(elt, INSTANCE) == null;
    }

    @Override
    public boolean remove(E elt) {
        return source.remove(elt, INSTANCE);
    }

    @Override
    public boolean contains(E elt) {
        return source.containsKey(elt);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public Iterator<E> iterator() {
        return source.keySet().iterator();
    }
}

