package com.epam.triangle.sevice;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;

import java.nio.file.Files;
import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class TriangleCalculator {

    public static TriangleCalculator getInstance(){
        return TriangleCalculatorHolder.INSTANCE;
    }
    private TriangleCalculator(){}

    private static class TriangleCalculatorHolder{
        private static final TriangleCalculator INSTANCE = new TriangleCalculator();
    }

    public boolean isRight(Triangle triangle){

        DistanceCalculator calculator = DistanceCalculator.getInstance();
        double[] sides = allTriangleSides(triangle,calculator);
        Arrays.sort(sides);

        double hypotenuse = sides[2];
        double legOneSquare = pow(sides[1],2);
        double legTwoSquare =  pow(sides[0],2);
        double sumLegsSquare = sqrt(legOneSquare + legTwoSquare);
        return Double.compare(hypotenuse , sumLegsSquare) == 0;
    }


    public boolean isIsosceles(Triangle triangle){
        DistanceCalculator calculator = DistanceCalculator.getInstance();
        double[] sides = allTriangleSides(triangle,calculator);

        double sideOne = sides[0];
        double sideTwo = sides[1];
        double sideThree = sides[2];

        return Double.compare(sideOne,sideTwo) == 0
                || Double.compare(sideTwo,sideThree) ==0
                || Double.compare(sideThree,sideOne) ==0;


    }

    public boolean isEquilateral(Triangle triangle){
        DistanceCalculator calculator = DistanceCalculator.getInstance();
        double[] sides = allTriangleSides(triangle,calculator);

        double sideOne = sides[0];
        double sideTwo = sides[1];
        double sideThree = sides[2];

        return (sideOne == sideTwo)
                &&(sideTwo == sideThree);

    }

    private double[] allTriangleSides(Triangle triangle, DistanceCalculator calculator){

        Point2D[] points = triangle.getAllPoints();
        double[] sides = new double[3];

        for(int i =0;i<sides.length;++i){
            Point2D pointOne = points[i %3];
            Point2D pointTwo = points[(i+1) % 3];
            sides[i] = calculator.calculateDistance(pointOne,pointTwo);
        }
        return sides;
    }


    public  boolean isObsute(Triangle triangle){
        DistanceCalculator calculator = DistanceCalculator.getInstance();
        double[] sides = allTriangleSides(triangle,calculator);
        Arrays.sort(sides);

        double theBiggestSideSquare = pow(sides[2],2);
        double smallerSideOneSquare = pow(sides[1],2);
        double smallerSideTwoSquare = pow(sides[0],2);

        return theBiggestSideSquare > smallerSideOneSquare + smallerSideTwoSquare;
    }

    public boolean isAcute(Triangle triangle){
        return !isObsute(triangle) && !isRight(triangle);

    }

    public double perimeter(Triangle triangle){
        DistanceCalculator calculator = DistanceCalculator.getInstance();
        double[] sides = allTriangleSides(triangle,calculator);

        double perimiter =0;
        for (double side:sides){
            perimiter +=side;
        }
        return perimiter;
    }


    public double square(Triangle triangle){
        DistanceCalculator calculator = DistanceCalculator.getInstance();
        double[] sides = allTriangleSides(triangle,calculator);

        double sideOne = sides[0];
        double sideTwo = sides[1];
        double sideTree = sides[2];

        double semiPerimeter = perimeter(triangle)/2;

        double square = sqrt(semiPerimeter
                * (semiPerimeter  -sideOne)
                * (semiPerimeter - sideTwo)
                * (semiPerimeter - sideTree));
        return square;
    }

    public static void main(String ... args){
        Point2D[] arr = new Point2D[3];

        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Triangle triangle = new Triangle(arr);

        TriangleCalculator calculator = TriangleCalculator.getInstance();

        System.out.println(calculator.isRight(triangle));
        System.out.println(calculator.isIsosceles(triangle));
        System.out.println(calculator.isEquilateral(triangle));

    }
}
