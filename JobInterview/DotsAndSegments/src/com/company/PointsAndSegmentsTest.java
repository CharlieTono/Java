package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PointsAndSegmentsTest {

    PointsAndSegments pas = new PointsAndSegments();

    @org.junit.Test
    public void testGetNumberCoveringSegmentsOverPoints() {

        List<Double> points = Arrays.asList(2d, 4d, 7d, 10d, 12d, 14d);

        List<Segment> segments = Arrays.asList(
                new Segment(0, 5),
                new Segment(1, 6),
                new Segment(3, 8),
                new Segment(9, 12),
                new Segment(12, 15)
        );

        List<Integer> expected = Arrays.asList(2, 3, 1, 1, 2, 1);
        List<Integer> toCompare = pas.getNumberCoveringSegmentsOverPoints(points, segments);

        assertEquals(expected, toCompare);

    }
}