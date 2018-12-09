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

    public static void main(String ... args){
        Point2D[] arr = new Point2D[3];
        for (int i =0;i<3;++i){
            arr[i] = new Point2D(1,2);
        }

        Triangle triangle = new Triangle(arr);
        System.out.println(triangle);
    }


}
