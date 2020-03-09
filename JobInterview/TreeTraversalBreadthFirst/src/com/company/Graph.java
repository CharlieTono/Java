package com.company;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    Node root;

    public List<Integer> getNeighborhoods(Node currentRoot) {

        List<Integer> result = new ArrayList<>();

        for (Node child : currentRoot.children) {
            result.add(child.weight);
        }

        return result;
    }
}
