package com.company.shapes;

public class Line extends Shape {
    private int length;

    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    @Override
    public void draw() {
        while (length > 0) {
            System.out.print(this.getSymbol());
            length--;
        }
        System.out.println();
    }
}
