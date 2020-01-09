package com.company;

import java.util.List;

public class MaxPoint {

    public double leftCoordinateOfSegmentCoveringMaxPoint(List<Double> points, double d) {

        double result = Double.MIN_VALUE;
        int maxPoints = 0;

        for (double leftCoordinate : points) {
            double rightCoordinate = leftCoordinate + d;
            int coveredPoints = 0;
            for (double currentPoint : points) {
                if (currentPoint >= leftCoordinate && currentPoint <= rightCoordinate) {
                    coveredPoints++;
                }
            }

            if (coveredPoints > maxPoints) {
                maxPoints = coveredPoints;
                result = leftCoordinate;
            }
        }
        return result;
    }
}
