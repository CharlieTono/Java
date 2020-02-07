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
            if (currentRoot.children.size() != 0) {
                max += rHeight(child);
                if (root != null) {
                    return max++;
                }
            }
        }
        return max;
    }

}
