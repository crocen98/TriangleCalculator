package com.epam.triangle.sevice;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;


import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class TriangleCalculator {

    private TriangleSides sides;
    public TriangleCalculator(TriangleSides sides){
        this.sides = sides;
    }





    public double perimeter(Triangle triangle){
        double[] sides = this.sides.getAll(triangle);

        double perimiter = 0;
        for (double side:sides){
            perimiter +=side;
        }
        return perimiter;
    }


    public double square(Triangle triangle){
        double[] sides = this.sides.getAll(triangle);

        double sideOne = sides[0];
        double sideTwo = sides[1];
        double sideTree = sides[2];

        double semiPerimeter = perimeter(triangle)/2;

        double square = sqrt(semiPerimeter
                * (semiPerimeter  -sideOne)
                * (semiPerimeter - sideTwo)
                * (semiPerimeter - sideTree));
        return round(square*100d)/100d;
    }
}
