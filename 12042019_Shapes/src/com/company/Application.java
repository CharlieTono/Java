package com.company;

import com.company.shapes.Line;
import com.company.shapes.Picture;
import com.company.shapes.Rectangle;
import com.company.shapes.Shape;

public class Application {

    public static void main(String[] args) {

        Shape shape01 = new Line('*', 10);
        Shape shape02 = new Rectangle('*', 6, 3);
        Shape shape03 = new Line('@', 5);
        Shape shape04 = new Rectangle('@', 4, 3);

        Shape[] shapes = {shape01, shape02, shape03, shape04};

        Picture picture = new Picture('*', shapes);

        picture.draw();

    }
}
