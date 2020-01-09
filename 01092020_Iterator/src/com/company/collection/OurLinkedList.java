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

        Node needle = getNode(index);

        return needle.value;
    }

    @Override
    public void set(Object o, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node needle = getNode(index);

        needle.value = o;
    }

    private Node getNode(int index) {

        Node needle = first;
        for (int i = 0; i < index; i++) {
            needle = needle.next;
        }
        return needle;
    }

    @Override
    public Object removeById(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node nodeToRemove = getNode(index);
        Node left = nodeToRemove.prev;
        Node right = nodeToRemove.next;
        Object value = nodeToRemove.value;

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

//        Node deletedNode = first;
//        Object res = deletedNode.value;
//
//        Node right;
//        Node left;
//        if (index == 0) {
//            right = deletedNode.next;
//            deletedNode.value = null;
//            deletedNode.next=null;
//            right.prev = null;
//            first = right;
//        } else if (index == size - 1) {
//            res = last.value;
//            deletedNode = last;
//            left = deletedNode.prev;
//            deletedNode.value = null;
//            deletedNode.prev = null;
//            left.next = null;
//            last = left;
//        } else {
//            for (int i = 0; i < index; i++) {
//                deletedNode = deletedNode.next;
//            }
//            res = deletedNode.value;
//            right = deletedNode.next;
//            left = deletedNode.prev;
//            left.next = right;
//            right.prev = left;
//            deletedNode.value = null;
//        }
//        size--;
//        return res;
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

    @Override
    public Object max(OurComparator comparator) {

        Node max = first;
        Node currentNode = first.next;

        for (int i = 1; i < size; i++) {
            if (comparator.compare(max, currentNode) < 0) {
                max = currentNode;
            }
            currentNode = currentNode.next;
        }
        return max;
    }

    @Override
    public Object min(OurComparator comparator) {

        Node min = first;
        Node currentNode = first.next;

        for (int i = 1; i < size; i++) {
            if (comparator.compare(min, currentNode) > 0) {
                min = currentNode;
            }
            currentNode = currentNode.next;
        }
        return min;
    }

    @Override
    public void sort(OurComparator comparator) {

        Node left = first;
        Node right = first.next;
        Node temp;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare(left, right) > 0) {
                    temp = left;
                    left = right;
                    right = temp;
                }
            }
        }
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
