package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {

    List<Node> children = new ArrayList<>();
    int weight;

    public Node(int weight) {
        this.weight = weight;
    }
}
