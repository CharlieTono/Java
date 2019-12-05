package com.company.shapes;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {

        for (int i = 1; i <= height; i++) {
            System.out.print(getSymbol() + " ");
            if (i == 1 || i == height) {
                for (int j = 0; j < width - 2; j++) {
                    System.out.print(getSymbol() + " ");
                }
            } else {
                for (int j = 0; j < width - 2; j++) {
                    System.out.print("  ");
                }
            }
            System.out.println(getSymbol());
        }

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.print(this.getSymbol() + " ");
//            }
//            System.out.println();
//        }
    }
}
