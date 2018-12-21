package com.epam.triangle.observer.impl;

import com.epam.triangle.entity.Point2D;


public class TriangleObservable extends Shape2DObservable {
    public TriangleObservable(long id, Point2D[] points) {
        super(id, points);
    }


}
