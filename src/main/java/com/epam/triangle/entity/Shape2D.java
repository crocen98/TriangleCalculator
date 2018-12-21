package com.epam.triangle.entity;

import java.util.Arrays;
import java.util.Objects;

public abstract class Shape2D {

    private final long id;
    private final Point2D[] points;

    public Shape2D(long id ,Point2D[] points) {
        this.points = points;
        this.id = id;
    }


    public Point2D getPoint(int pointNumber){
        return points[pointNumber];
    }

    public void setPoint(Point2D point, int pointNumber){
        points[pointNumber] = point;
    }

    public long getId() {
        return id;
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
        return "Shape2D{" +
                "id=" + id +
                ", points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape2D shape2D = (Shape2D) o;
        return id == shape2D.id &&
                Arrays.equals(points, shape2D.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }
}
