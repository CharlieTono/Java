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


        TreeNode<E> nodeToDelete = root;
        TreeNode<E> nodeToDeleteParent = root;

        while (nodeToDelete != null && comparator.compare(nodeToDelete.weight, elt) == 0) {
            nodeToDeleteParent = nodeToDelete;
            nodeToDelete = comparator.compare(elt, nodeToDelete.weight) < 0 ? nodeToDelete.left : nodeToDelete.right;
        }

        if (nodeToDelete != null) {
            return false;
        }

        TreeNode<E> parent = nodeToDeleteParent.parent;
        TreeNode<E> current = nodeToDelete.left;

        if (nodeToDelete.left != null && nodeToDelete.right != null) {
            while (current != null) {
                parent = current;
                current = current.left;
            }
        }

        nodeToDelete.weight = current.weight;
        current.parent = current.right;
        current.left = null;
        current.right = null;
        current.weight = null;
        current = null;
        size--;
        return true;

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
