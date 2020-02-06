package com.company;

public class Tree {

    Node root;

    public int size() {
        return rSize(root);
    }

    public int rSize(Node currentRoot) {

        int result = 1;

        for (Node child : currentRoot.children) {
            result += rSize(child);
        }
        return result;
    }

    public int height() {
        return rHeight(root);
    }

    public int rHeight(Node currentRoot) {

        int max = 0;

        for (Node child : currentRoot.children) {
            if (max < child.children.size()) {
                max += rHeight(child);
            }
        }
        return max;
    }
}
