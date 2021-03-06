package com.company;

import java.util.Comparator;
import java.util.Iterator;

public class OurSetTree<E> extends OurAbstractSet<E> {

    private int size;
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
            linealRemove(nodeToRemove);
        } else {
            junctionRemove(nodeToRemove);
        }

        size--;

        return true;
    }

    private void linealRemove(TreeNode<E> nodeToRemove) {

        TreeNode<E> parent = nodeToRemove.parent;
        TreeNode<E> child = nodeToRemove.left == null ? nodeToRemove.right : nodeToRemove.left;

        if (parent == null) {
            clearNode(nodeToRemove);
            root = child;
        } else if (parent.right == nodeToRemove) {
            parent.right = child;
        } else {
            parent.left = child;
        }

        if (child != null) {
            child.parent = parent;
        }
        clearNode(nodeToRemove);
    }

    private void junctionRemove(TreeNode<E> nodeToRemove) {

        TreeNode<E> lastNode = nodeToRemove.right;

        while (lastNode.left != null) {
            lastNode = lastNode.left;
        }

        nodeToRemove.weight = lastNode.weight;
        linealRemove(lastNode);
    }

    private void clearNode(TreeNode<E> nodeRemove) {
        nodeRemove.weight = null;
        nodeRemove.left = null;
        nodeRemove.right = null;
        nodeRemove.parent = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new OurTreeSetIterator<>(this);
    }

    static class TreeNode<E> {
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

class OurTreeSetIterator<E> implements Iterator<E> {

    private OurSetTree<E> treeSet;
    private OurSetTree.TreeNode<E> current;

    public OurTreeSetIterator(OurSetTree<E> treeSet) {
        this.treeSet = treeSet;
        this.current = treeSet.root == null ? null : getLeast(treeSet.root);
    }

    /**
     * finds the node with the least element of the collection
     *
     * @param vertex - the starting point - root. Must be non-zero
     * @return the node with the least element of the tree
     */
    private OurSetTree.TreeNode getLeast(OurSetTree.TreeNode<E> vertex) {

        while (vertex.left != null) {
            vertex = vertex.left;
        }
        return vertex;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {

        E res = current.weight;

        if (current.right != null) {
            current = getLeast(current.right);
        } else {
            current = firstRightParent(current);
        }
        return res;
    }

    /**
     * the method finds the first parent which is to the right from current
     *
     * @param current element
     * @return next element by order if exists or null, if current is the most right element in the treeSet
     */

    private OurSetTree.TreeNode<E> firstRightParent(OurSetTree.TreeNode<E> current) {
        OurSetTree.TreeNode<E> newParent = current.parent;
        OurSetTree.TreeNode<E> newChild = current;
        while (newParent != null && newParent.left != newChild) {
            newChild = newParent;
            newParent = newParent.parent;
        }
        return newParent;

//        while (current.parent != null && current.parent.left != current) { // second solution
//            current= current.parent;
//        }
//        return current.parent;
    }
}