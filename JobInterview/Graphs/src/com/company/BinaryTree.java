package com.company;

public class BinaryTree {

    BinaryNode root;

    public int getSize() {
        return getVertexTotalNumber(root);
    }

    public int getVertexTotalNumber(BinaryNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getVertexTotalNumber(root.left) + getVertexTotalNumber(root.right);
        }
    }

    public int getVertexTotalNumberNotOptimal(BinaryNode root) {
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + getVertexTotalNumberNotOptimal(root.right);
        if (root.right == null)
            return 1 + getVertexTotalNumberNotOptimal(root.left);
        return 1 + getVertexTotalNumber(root.left) + getVertexTotalNumber(root.right);

    }

    public int getHeight() {
        return getTreeHeight(root);
    }

    public int getTreeHeight(BinaryNode root) {
        if (root == null)
            return 0;
        int heightLeft = getTreeHeight(root.left);
        int heightRight = getTreeHeight(root.right);

        return Math.max(heightLeft, heightRight) + 1;
    }
}

