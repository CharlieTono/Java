package com.company;

import java.util.*;

public class BFS {

    private Deque<Integer> ourDeque;
    private ArrayList<ArrayList<Integer>> ourList;
    private Integer[] dist;

    public BFS(ArrayList<ArrayList<Integer>> ourList) {
        this.ourList = ourList;
        ourDeque = new ArrayDeque<>();
        dist = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0};
    }

    public int breadthFirst(int root, int endPoint) {

        Set<Integer> result = new HashSet<>();
        ourDeque.addLast(root);
        while (ourDeque.size() > 0) {
            int currentVertex = ourDeque.removeFirst();
            if (ourList.get(0).get(1) == endPoint && currentVertex == root) {
                return 1;
            }
            for (int i = 0; i < ourList.size(); i++) {
                for (int j = 0; j < ourList.get(i).size(); j++) {
                    int childVertex = ourList.get(i).get(j);
                    if (dist[childVertex] == 0) {
                        dist[childVertex] = 1 + dist[currentVertex];
                        ourDeque.add(childVertex);
                        result.add(childVertex);
                        if (childVertex == endPoint) {
                            return result.size() - 2;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
