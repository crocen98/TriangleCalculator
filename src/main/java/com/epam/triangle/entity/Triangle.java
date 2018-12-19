package com.epam.triangle.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Triangle implements Serializable {

    private final Point2D[] points;

    public Triangle(Point2D[] points) {
        this.points = points;
    }

    public Point2D getPoint2D1(){
        return points[0];
    }

    public Point2D getPoint2D2(){
        return points[1];
    }

    public Point2D getPoint2D3(){
        return points[2];
    }

    public void setPoint2D1(Point2D point){
        points[0] = point;
    }

    public void setPoint2D2(Point2D point){
         points[1] = point;
    }

    public void setPoint2D3(Point2D point){
         points[2] = point;
    }



    public Point2D[] getAllPoints(){
        Point2D[] points = new Point2D[3];
        for(int i = 0 ; i < points.length ; ++i){
            points[i] = this.points[i];
        }
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                " points=" + Arrays.toString(points) +
                '}';
    }
}
