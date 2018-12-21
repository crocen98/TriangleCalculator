package com.epam.triangle.sevice;

import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.entity.Triangle;


import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class TriangleCalculator extends BaseShape2DCalculator {

    private TriangleSides sides;
    public TriangleCalculator(TriangleSides sides){
        this.sides = sides;
    }


    @Override
    public double perimeter(Shape2D triangle) {
        if(triangle instanceof Triangle) {
            double[] sides = this.sides.getAll(triangle);

            double perimiter = 0;
            for (double side : sides) {
                perimiter += side;
            }
            return perimiter;
        } else {
            return checkNextPerimetr(triangle);
        }
    }

    @Override
    public double square(Shape2D triangle) {
        if(triangle instanceof Triangle) {
            double[] sides = this.sides.getAll(triangle);
            double sideOne = sides[0];
            double sideTwo = sides[1];
            double sideTree = sides[2];
            double semiPerimeter = perimeter(triangle) / 2;
            double square = sqrt(semiPerimeter
                    * (semiPerimeter - sideOne)
                    * (semiPerimeter - sideTwo)
                    * (semiPerimeter - sideTree));
            return round(square * 100d) / 100d;
        } else {
            return checkNextSquare(triangle);

        }
    }
}
