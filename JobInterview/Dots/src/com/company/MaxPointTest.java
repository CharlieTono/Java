package com.company;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class MaxPointTest {

    MaxPoint maxPoint = new MaxPoint();

    @org.junit.Test
    public void leftCoordinateOfSegmentCoveringMaxPoint() {

        List<Double> points = Arrays.asList(0.0, 0.1, 0.7, 0.5, 0.8, 0.3, 0.6, 1.0);
        double d = 0.3;
        assertEquals(0.5, maxPoint.leftCoordinateOfSegmentCoveringMaxPoint(points, d));
    }
}