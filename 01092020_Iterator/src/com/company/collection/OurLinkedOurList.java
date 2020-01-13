package com.company.collection;

import java.util.Iterator;

public class OurLinkedOurList<E> implements OurList<E>, Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(E o) {
        if (size > 0) {
            Node<E> newNode = new Node<>(null, last, o);
            last.next = newNode;
            last = newNode;
        } else {
            Node<E> newNode = new Node<>(null, null, o);
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> needle = getNode(index);

        return needle.value;
    }

    @Override
    public void set(E o, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> needle = getNode(index);

        needle.value = o;
    }

    private Node<E> getNode(int index) {

        Node<E> needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }
        return needle;
    }

    @Override
    public E removeById(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> nodeToRemove = getNode(index);
        Node<E> left = nodeToRemove.prev;
        Node<E> right = nodeToRemove.next;
        E value = nodeToRemove.value;

        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        nodeToRemove.value = null;

        if (index > 0 && index < size - 1) {
            left.next = right;
            right.prev = left;
        } else if (index == 0) {
            right.prev = null;
            first = right;
        } else {
            left.next = null;
            last = left;
        }
        size--;
        return value;
    }

    @Override
    public boolean remove(E o) {

        Node<E> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(o)) {
                removeById(i);
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean contains(E o) {

        Node<E> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public E max(OurComparator<E> comparator) {

        Node<E> max = first;
        Node<E> currentNode = first.next;

        for (int i = 1; i < size; i++) {
            if (comparator.compare((E)max, (E)currentNode) < 0) {
                max = currentNode;
            }
            currentNode = currentNode.next;
        }
        return (E)max;
    }

    @Override
    public E min(OurComparator<E> comparator) {

        Node<E> min = first;
        Node<E> currentNode = first.next;

        for (int i = 1; i < size; i++) {
            if (comparator.compare((E)min, (E)currentNode) > 0) {
                min = currentNode;
            }
            currentNode = currentNode.next;
        }
        return (E)min;
    }

    @Override
    public void sort(OurComparator<E> comparator) {
    }

    @Override
    public Iterator<E> iterator() {
        return new OurLinkedListIterator();
    }

    class OurLinkedListIterator implements Iterator<E> {

        Node<E> currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E res = currentNode.value;
            currentNode = currentNode.next;
            return res;
        }
    }

    private static class Node<E> {

        Node<E> next;
        Node<E> prev;
        E value;

        public Node(Node next, Node prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
