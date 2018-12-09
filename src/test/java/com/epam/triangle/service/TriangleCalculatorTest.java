package com.epam.triangle.service;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.sevice.TriangleCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class TriangleCalculatorTest {
    private final TriangleCalculator CALCULATOR = TriangleCalculator.getInstance();



 @Test
    public void shouldCheckIsTriangleIsRightAndReturnFalse(){
     Point2D[] arr = new Point2D[3];

     arr[0] = new Point2D(4,0);
     arr[1] = new Point2D(6,0);
     arr[2] = new Point2D(5,sqrt(3));

     Triangle triangle = new Triangle(arr);

     Assert.assertFalse(CALCULATOR.isRight(triangle));

 }

    @Test
    public void shouldCheckIsTriangleIsRightAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4.342,0);
        arr[1] = new Point2D(0,6.342);
        arr[2] = new Point2D(0,0);

        Triangle triangle = new Triangle(arr);

        Assert.assertTrue(CALCULATOR.isRight(triangle));
    }


    @Test
    public void shouldGettingIsoscelesAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(0,10);
        arr[1] = new Point2D(-4,0);
        arr[2] = new Point2D(4,0);

        Triangle triangle = new Triangle(arr);

        Assert.assertTrue(CALCULATOR.isIsosceles(triangle));
    }


    @Test
    public void shouldGettingNotIsoscelesAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(0,10);
        arr[1] = new Point2D(-5,0);
        arr[2] = new Point2D(4,0);

        Triangle triangle = new Triangle(arr);

        Assert.assertFalse(CALCULATOR.isIsosceles(triangle));
    }


    @Test
    public void shouldGettingEquilateralAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.73);

        Triangle triangle = new Triangle(arr);

        Assert.assertTrue(CALCULATOR.isEquilateral(triangle));
    }

    @Test
    public void shouldGettingNotEquilateralAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.74);

        Triangle triangle = new Triangle(arr);

        Assert.assertFalse(CALCULATOR.isEquilateral(triangle));
    }


    @Test
    public void shouldGettingObsuteAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,1);
        arr[1] = new Point2D(100,3);
        arr[2] = new Point2D(3,1.73);

        Triangle triangle = new Triangle(arr);

        Assert.assertTrue(CALCULATOR.isObsute(triangle));
    }

    @Test
    public void shouldGettingNotObsuteAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.74);

        Triangle triangle = new Triangle(arr);

        Assert.assertFalse(CALCULATOR.isObsute(triangle));
    }

    @Test
    public void shouldGettingAcuteAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.74);


        Triangle triangle = new Triangle(arr);

        Assert.assertTrue(CALCULATOR.isAcute(triangle));
    }


    @Test
    public void shouldGettingNotAcuteAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,1);
        arr[1] = new Point2D(100,3);
        arr[2] = new Point2D(3,1.73);


        Triangle triangle = new Triangle(arr);

        Assert.assertFalse(CALCULATOR.isAcute(triangle));
    }


    @Test
    public void perimetrShouldEqualSix(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,-sqrt(3));


        Triangle triangle = new Triangle(arr);
        Triangle triangleTwo = new Triangle(arr);
        Assert.assertEquals(6.0,CALCULATOR.perimeter(triangle));
        Assert.assertEquals(6.0,CALCULATOR.perimeter(triangleTwo));

    }


    @Test
    public void squareShouldEqualSQRTFromTree(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,-sqrt(3));


        Triangle triangle = new Triangle(arr);
        Triangle triangleTwo = new Triangle(arr);
        Assert.assertEquals(1.73,CALCULATOR.square(triangle));
        Assert.assertEquals(1.73,CALCULATOR.square(triangleTwo));

    }

}
