package com.company;

import java.util.Deque;
import java.util.List;

public class QueueArray {

    Deque<Double> myQueue;

    public double leftCoordinateInQueueCoveringMaxPoint(List<Double> points, double d) {

        double result = Double.MIN_VALUE;
        int maxPoints = 0;

        for (double point : points) {
            myQueue.addLast(point);
            int coveredPoints = 0;
//            while () {
//                maxPoints = coveredPoints;
//                result = leftCoordinate;
//                coveredPoints++;
//            }
//            double rightCoordinate = leftCoordinate + d;
//
//            for (double currentPoint : points) {
//                if (currentPoint >= leftCoordinate && currentPoint <= rightCoordinate) {
//
//                }
//            }

        }
        return result;
    }

}
