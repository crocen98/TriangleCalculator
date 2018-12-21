package com.epam.triangle.repository.impl.specification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.repository.Specification;

import com.epam.triangle.sevice.cor.impl.TriangleCalculator;

public class SquareSmallerThanSpecification implements Specification<Triangle> {

    double square;

    public TriangleCalculator calculator;
    public SquareSmallerThanSpecification(double square,TriangleCalculator calculator){
        this.square = square;
        this.calculator = calculator;
    }
    @Override
    public boolean specify(Triangle object) {
        double square = calculator.perimeter(object);
        return square < this.square;
    }

}
