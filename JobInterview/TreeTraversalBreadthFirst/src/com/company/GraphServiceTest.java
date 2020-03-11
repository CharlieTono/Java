package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphServiceTest {

    @Test
    public void testBFS_severalVertices() {
        GraphService graphService = new GraphService();
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(4, 2, 0),
                Arrays.asList(1, 3, 5, 6),
                Arrays.asList(2, 4),
                Arrays.asList(1, 3),
                Arrays.asList(2, 6), 
                Arrays.asList(2, 5)
        );
        assertEquals(0, graphService.getDistance(graph, 0, 0));
        assertEquals(1, graphService.getDistance(graph, 0, 1));
        assertEquals(2, graphService.getDistance(graph, 0, 2));
        assertEquals(2, graphService.getDistance(graph, 0, 4));
        assertEquals(3, graphService.getDistance(graph, 0, 3));
        assertEquals(1, graphService.getDistance(graph, 0, 5));
        assertEquals(2, graphService.getDistance(graph, 0, 6));
        assertEquals(1, graphService.getDistance(graph, 5, 6));
        assertEquals(2, graphService.getDistance(graph, 5, 1));
        assertEquals(3, graphService.getDistance(graph, 5, 0));
    }

}