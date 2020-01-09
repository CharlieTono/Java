package com.company;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MinPointsInSegmentsTest {

    MinPointsInSegments min = new MinPointsInSegments();

    @org.junit.Test
    public void getMinPointsNumber() {

        List<Segment>segments = Arrays.asList(
                new Segment(0.6, 0.9),
                new Segment(0.2, 0.7),
                new Segment(0.4, 0.8),
                new Segment(0.1, 0.5),
                new Segment(0, 0.3)
        );

        assertEquals(2, min.getMinPointsNumber(segments));
    }
}