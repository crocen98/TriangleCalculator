package com.epam.triangle.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Triangle extends Shape2D implements Serializable {


    public Triangle(long id,Point2D[] points){
        super(id,points);
    }

//    private final Point2D[] points;
//
//    public Triangle(Point2D[] points) {
//        this.points = points;
//    }
//
//
//    public Point2D getPoint(int pointNumber){
//        return points[pointNumber];
//    }
//
//    public void setPoint(Point2D point, int pointNumber){
//        points[pointNumber] = point;
//    }
//
//    public Point2D[] getAllPoints(){
//        Point2D[] points = new Point2D[3];
//        for(int i = 0 ; i < points.length ; ++i){
//            points[i] = this.points[i];
//        }
//        return points;
//    }


    @Override
    public String toString() {
        return "Triangle{ "
                + Arrays.toString(super.getAllPoints())+" " +
                "}";
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
