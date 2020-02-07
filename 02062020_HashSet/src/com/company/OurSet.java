package com.company;

public interface OurSet<E> extends Iterable<E> {

    /**
     * adds a new element to the set
     *
     * @param elt to find
     * @return true if the set was changed
     */

    boolean add(E elt);

    /**
     * removes the element from the set
     *
     * @param elt to find
     * @return true if the set was changed
     */

    boolean remove(E elt);

    /**
     * determines whether the element in the set
     *
     * @param elt to find
     * @return true if set contains the needed element
     */

    boolean contains(E elt);

    int size();

    /**
     * adds all the elements from the other to this set
     *
     * @param other elements which must be added
     * @return true if set was changed
     */

    boolean addAll(OurSet<E> other);

    /**
     * removes all the elements appearing in the other from this set
     *
     * @param other elements which must be removed
     * @return true if set was changed
     */

    boolean removeAll(OurSet<E> other);

    /**
     * retains all the elements appearing in the both this and other sets
     *
     * @param other elements which must be retained
     * @return true if set was changed
     */

    boolean retainAll(OurSet<E> other);
}
