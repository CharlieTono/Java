package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class OurHashSet<E> implements OurSet<E> {

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
    public boolean addAll(OurSet<E> other) {
        OurHashSet<E> narrowedOther = (OurHashSet<E>) other;
        boolean res = false;

        for (E elt : narrowedOther.source.keySet()) {
            res |= this.add(elt); //res = this.add(elt) | res
        }
        return res;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        OurHashSet<E> narrowedOther = (OurHashSet<E>) other;
        boolean res = false;

        for (E elt : narrowedOther.source.keySet()) {
            res |= this.remove(elt);

        }
        return res;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
        OurHashSet<E> narrowedOther = (OurHashSet<E>) other;
        OurHashSet<E> narrowedOtherCopy = new OurHashSet<>();

        boolean res = false;

        for (E elt : narrowedOther.source.keySet()) {
            if (this.contains(elt)) {
                res |= narrowedOtherCopy.add(elt) | res;
            }
        }

        for (E elt : source.keySet()) {
            if (!narrowedOtherCopy.contains(elt)) {
                res |= this.remove(elt) | res;
            }
        }
        return res;

    }
}
