package com.epam.triangle.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Triangle extends Shape2D implements Serializable {


    public Triangle(long id,Point2D[] points){

        super(id);
        this.points = points;
    }

    private final Point2D[] points;




    public Point2D getPoint(int pointNumber){
        return points[pointNumber];
    }

    public void setPoint(Point2D point, int pointNumber){
        points[pointNumber] = point;
    }



    public Point2D[] getAllPoints(){
        Point2D[] points = new Point2D[this.points.length];
        for(int i = 0 ; i < points.length ; ++i){
            points[i] = this.points[i];
        }
        return points;
    }


    @Override
    public String toString() {
        return "Triangle{ "
                + Arrays.toString(getAllPoints())+" " +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }
}
