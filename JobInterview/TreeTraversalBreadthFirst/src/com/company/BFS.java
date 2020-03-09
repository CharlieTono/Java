package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS {

    private Deque<Integer> ourDeque;
    private Graph graph;
    private Integer[] dist;

    public BFS(Graph graph) {
        this.ourDeque = new ArrayDeque<>();
    }

    public void breadthFirst(int root) {
        ourDeque.addLast(root);
        while (ourDeque.size() > 0) {
            int currentVertex = ourDeque.removeFirst();
            for (int childVertex : graph.getNeighborhoods(new Node (currentVertex))) {
                if (dist[childVertex] == 0) {
                    dist[childVertex] = 1 + dist[currentVertex];
                    ourDeque.add(childVertex);
                }
            }
        }
    }
}
