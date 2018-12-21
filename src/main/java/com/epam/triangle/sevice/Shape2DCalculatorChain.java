package com.epam.triangle.sevice;

import com.epam.triangle.entity.Shape2D;

public interface Shape2DCalculatorChain {
    double perimeter(Shape2D shape);
    double square(Shape2D shape);

    Shape2DCalculatorChain linkWith(Shape2DCalculatorChain chain);
}
