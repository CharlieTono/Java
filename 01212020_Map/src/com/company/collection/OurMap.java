package com.company.collection;

public interface OurMap<E, T> {

    /**
     *
     * @param key
     * @param value
     * @return if the key has already existed in a structure
     */

    public void put(E key, T value);

    public T get(E key);

    public boolean contains(E key);

    public boolean remove(E key);

    public int size();
}
