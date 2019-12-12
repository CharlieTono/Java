package com.company.collection;

import com.company.comparator.OurComparator;

public interface List {

    int size();

    void append(Object o);

    Object get(int index);

    void set(Object o, int index);

    Object removeById(int index);

    boolean remove(Object o);

    boolean contains(Object o);

    /**
     * finds max element in the list according to the comparator
     *
     * @param comparator an object comparing the elements of the list
     * @return max element according to comparator
     * @throws EmptyListException in case if list is empty
     */

    Object max(OurComparator comparator);

    Object min(OurComparator comparator);

    void sort(OurComparator comparator);

}
