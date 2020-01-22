package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointsAndSegments {

    public List<Integer> getNumberCoveringSegmentsOverPoints(List<Double> numbers, List<Segment> segments) {

        List<Point> points = new ArrayList<>();
        for (double num : numbers) {
            points.add(new Point(num, Point.KIND_POINT));
        }

        for (Segment segment : segments) {
            points.add(new Point(segment.left, Point.KIND_LEFT));
            points.add(new Point(segment.right, Point.KIND_RIGHT));
        }

        Collections.sort(points);
        int counter = 0;
        List<Integer> res = new ArrayList<>();

        for (Point point : points) {
            if (point.kind == Point.KIND_LEFT) {
                counter++;
            } else if (point.kind == Point.KIND_RIGHT) {
                counter--;
            } else {
                res.add(counter);
            }
        }
        return res;
    }

    static class Point implements Comparable<Point> {

        public final static int KIND_LEFT = 0;
        public final static int KIND_POINT = 1;
        public final static int KIND_RIGHT = 2;

        double value;
        int kind;

        public Point(double value, int kind) {
            this.value = value;
            this.kind = kind;
        }

        @Override
        public int compareTo(Point other) {

            int result = Double.compare(this.value, other.value);
            if (result != 0) {
                return result;
            } else {
                return Integer.compare(this.kind, other.kind);
            }
            
//            if (this.value < other.value) {
//                return -1;
//            }
//            if (this.value > other.value) {
//                return 1;
//            }
//            if (this.kind < other.kind) {
//                return -1;
//            }
//            if (this.kind > other.kind) {
//                return 1;
//            }
//            return 0;
        }
    }
}
