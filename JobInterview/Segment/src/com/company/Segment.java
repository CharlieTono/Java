package com.company;

public class Segment implements Comparable<Segment>{

    double left;
    double right;

    public Segment(double left, double right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Segment another) {
        return Double.compare(this.left, another.left);
    }
}
