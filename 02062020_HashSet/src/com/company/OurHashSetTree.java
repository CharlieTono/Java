package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OurHashSetTree<E> implements OurSet<E> {

    final static Object INSTANCE = new Object();

    private Map<E, Object> source;
    Node<E> root;
    private Comparator<E> comparator;

    public OurHashSetTree(Node<E> root) {
        this.source = new HashMap<>();
        this.root = root;
        this.comparator = new ComparatorComparable<>();
    }

    @Override
    public int size() {
        return getVertexTotalNumber(root);
    }

    private int getVertexTotalNumber(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getVertexTotalNumber(root.left) + getVertexTotalNumber(root.right);
        }
    }

    @Override
    public boolean add(E elt) {
        if (findPlaceIntBinaryTree(root, elt) == 0) {
            return true;
        }
        return false;
    }

    private int findPlaceIntBinaryTree(Node<E> root, E elt) {
        if (root.left == null) {
            Node<E> ourNode = new Node(elt);
            root.left = ourNode;
            return 0;
        }
        if (root.right == null) {
            Node<E> ourNode = new Node(elt);
            root.right = ourNode;
            return 0;
        }
        if (comparator.compare(elt, root.weight) < 0) {
            return findPlaceIntBinaryTree(root.left, elt);
        } else if (comparator.compare(elt, root.weight) > 0) {
            return findPlaceIntBinaryTree(root.right, elt);
        } else {
            return 0;
        }
    }

    @Override
    public boolean contains(E elt) {
        return false;
    }

    @Override
    public boolean remove(E elt) {
        return false;
    }

    @Override
    public boolean addAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        return false;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return source.keySet().iterator();
    }
}

class Node<E> {

    Node<E> left;
    Node<E> right;
    E weight;

    public Node(E weight) {
        this.weight = weight;
    }
}

class ComparatorComparable<E> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        Comparable o1comparable = (Comparable) o1;
        return o1comparable.compareTo(o2);
    }
}
