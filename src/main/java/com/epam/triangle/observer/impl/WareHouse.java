package com.epam.triangle.observer.impl;

import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.entity.Shape2DParametrs;
import com.epam.triangle.observer.Observer;
import com.epam.triangle.sevice.DistanceCalculator;
import com.epam.triangle.sevice.Shape2DCalculator;
import com.epam.triangle.sevice.TriangleCalculator;
import com.epam.triangle.sevice.TriangleSides;

import java.util.HashMap;
import java.util.Map;

public class WareHouse implements Observer {

    private Map<Long, Shape2DParametrs> parametrs;
    private Shape2DCalculator calculator;



    public WareHouse(Map<Long,Shape2DParametrs> parametrs, Shape2DCalculator calculator){
        this.parametrs = parametrs;
        this.calculator = calculator;
    }

    public double getPerimetrByID(long id){
        return parametrs.get(id).getPerimeter();
    }

    public double getSquareByID(long id){
        return parametrs.get(id).getSquare();
    }

    @Override
    public void handleEvent(long id, Shape2D shape) {
        double perimetr = calculator.perimeter(shape);
        double square = calculator.square(shape);

        Shape2DParametrs changedParametrs = parametrs.get(id);
        changedParametrs.setPerimeter(perimetr);
        changedParametrs.setSquare(square);
    }


}
