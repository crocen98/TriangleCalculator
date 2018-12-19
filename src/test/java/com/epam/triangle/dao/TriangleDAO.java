package com.epam.triangle.dao;

import com.epam.triangle.entity.Triangle;

import java.util.Comparator;
import java.util.List;

public interface TriangleDAO {

    Triangle findByID(long id);
    List<Triangle> findBySquare(double square);
    List<Triangle> findByPerimeter(double perimeter);
    void sort(Comparator<Triangle> comparator);
}
