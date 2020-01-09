package com.company.collection;

public interface List<E> {

    int size();

    void append(E o);

    E get(int index);

    void set(E o, int index);

    E removeById(int index);

    boolean remove(E o);

    boolean contains(E o);

    /**
     * finds max element in the list according to the comparator
     *
     * @param comparator an object comparing the elements of the list
     * @return max element according to comparator
     * @throws EmptyListException in case if list is empty
     */

    E max(OurComparator<E> comparator);

    E min(OurComparator<E> comparator);

    void sort(OurComparator<E> comparator);

}
