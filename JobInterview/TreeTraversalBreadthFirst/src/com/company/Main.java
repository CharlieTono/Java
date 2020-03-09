package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Graph ourGraph = new Graph();
        Node ver01 = new Node(0);
        Node ver02 = new Node(1);
        Node ver03 = new Node(4);
        Node ver04 = new Node(5);

        ver01.children = Arrays.asList(ver02, ver03);
        ver03.children = Arrays.asList(ver04);
        ourGraph.root = ver01;

        BFS bfs = new BFS(ourGraph);
        bfs.breadthFirst(0);
    }
}
