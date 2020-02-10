package com.company;

import java.util.Comparator;
import java.util.Iterator;

public class OurSetTree<E> implements OurSet<E> {

    int size;
    TreeNode<E> root;
    private Comparator<E> comparator;

    public OurSetTree() {
        this.comparator = new ComparatorComparable<>();
    }

    public OurSetTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E elt) {

        if (root == null) {
            root = new TreeNode();
            root.weight = elt;
            size++;
            return true;
        }

        TreeNode<E> parent = root;
        TreeNode<E> current = root;

        while (current != null && comparator.compare(current.weight, elt) != 0) {
            parent = current;
            current = comparator.compare(elt, current.weight) < 0 ? current.left : current.right;
        }

        if (current != null) {
            return false;
        }

        current = new TreeNode<>();
        current.weight = elt;
        current.parent = parent;
        if (comparator.compare(parent.weight, elt) > 0) {
            parent.left = current;
        } else {
            parent.right = current;
        }
        size++;
        return true;
    }

    private TreeNode<E> getNode(E elt) {
        TreeNode<E> current = root;

        while (current != null && comparator.compare(current.weight, elt) != 0) {
            current = comparator.compare(elt, current.weight) < 0 ? current.left : current.right;
        }
        return current;
    }

    @Override
    public boolean contains(E elt) {
        return (getNode(elt) != null);
    }

    @Override
    public boolean remove(E elt) {

        TreeNode<E> nodeToRemove = getNode(elt);

        if (nodeToRemove == null) {
            return false;
        }

        if (nodeToRemove.left == null || nodeToRemove.right == null) {
            removeByFirstCase(nodeToRemove);
        } else {
            removeBySecondCase(nodeToRemove);
        }
        size--;
        return true;
    }

    private void removeByFirstCase(TreeNode<E> nodeToRemove) {

        TreeNode<E> parent = nodeToRemove.parent;

        if (nodeToRemove.left == null && nodeToRemove.right == null) {
//            nodeToRemove.parent = null;
//            nodeToRemove.weight = null;
        } else if (nodeToRemove.left == null) {
            TreeNode<E> rightChild = nodeToRemove.right;
            parent.right = rightChild;
            rightChild.parent = parent;
//            nodeToRemove.weight = null;
//            nodeToRemove.right = null;
            nodeToRemove.parent = null;
        } else {
            TreeNode<E> leftChild = nodeToRemove.left;
            parent.right = leftChild;
            leftChild.parent = parent;
            nodeToRemove.parent = null;
            //nodeToRemove.left = null;
            //nodeToRemove.weight = null;
        }
    }

    private void removeBySecondCase(TreeNode<E> nodeToRemove) {
        TreeNode<E> lastNode = nodeToRemove.right;

        while (lastNode != null) {
            lastNode = lastNode.left;
        }

        nodeToRemove.weight = lastNode.weight;
        removeByFirstCase(lastNode);

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
        return null;
    }

    private static class TreeNode<E> {
        TreeNode<E> parent;
        TreeNode<E> left;
        TreeNode<E> right;
        E weight;
    }
}

class ComparatorComparable<E> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        Comparable o1comparable = (Comparable) o1;
        return o1comparable.compareTo(o2);
    }
}
