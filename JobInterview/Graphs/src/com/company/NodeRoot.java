package com.company;

public class NodeRoot {

    int getVertexTotalNumber (Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getVertexTotalNumber(root.left) + getVertexTotalNumber(root.right);
        }
    }

    public int getTreeSize(Graph root) {
//        if (root == null) {
//            return 0;
//        } else {
//            if(root.children.left == null) {
//                return 1 + getTreeSize(root);
//            } else if (root.children.right == null){
//                return 0;
//            } else {
        return 0;
//        }
    }
}
