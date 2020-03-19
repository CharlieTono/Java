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
            int currentHeight = rHeight(child);
            if (max < currentHeight) {
                max = currentHeight;
            }
        }
        return 1 + max;

    }

    public int getTreeWeight(Node currentRoot) {
        int result = currentRoot.weight;

        for (Node child : currentRoot.children) {
            result += getTreeWeight(child);

        }
        return result;
    }

}
