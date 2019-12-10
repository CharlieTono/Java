package com.company.collection;

public class OurLinkedList implements List {

    private Node first;
    private Node last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(Object o) {
        if (size > 0) {
            Node newNode = new Node(null, last, o);
            last.next = newNode;
            last = newNode;
        } else {
            Node newNode = new Node(null, null, o);
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    @Override
    public void set(Object o, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.value = o;
    }

    @Override
    public Object removeById(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node deletedNode = first;
        Object res = deletedNode.value;

        Node right;
        Node left;
        if (index == 0) {
            right = deletedNode.next;
            deletedNode.value = null;
            deletedNode.next=null;
            right.prev = null;
            first = right;
        } else if (index == size - 1) {
            res = last.value;
            deletedNode = last;
            left = deletedNode.prev;
            deletedNode.value = null;
            deletedNode.prev = null;
            left.next = null;
            last = left;
        } else {
            for (int i = 0; i < index; i++) {
                deletedNode = deletedNode.next;
            }
            res = deletedNode.value;
            right = deletedNode.next;
            left = deletedNode.prev;
            left.next = right;
            right.prev = left;
            deletedNode.value = null;
        }
        size--;
        return res;
    }

    @Override
    public boolean remove(Object o) {

        Node currentNode = first;
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
    public boolean contains(Object o) {
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.value.equals(o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    private static class Node {
        Node next;
        Node prev;
        Object value;

        public Node(Node next, Node prev, Object value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
