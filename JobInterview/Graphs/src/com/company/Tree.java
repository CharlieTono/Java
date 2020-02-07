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

        int max = 1;

        for (Node child : currentRoot.children) {
            max++;
            if (currentRoot.children.size() != 0) {
                if (max < rHeight(child)) {
                    max += rHeight(child);
                }
            }
        }
        return max;
    }
}
