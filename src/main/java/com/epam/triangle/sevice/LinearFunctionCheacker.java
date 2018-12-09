package com.epam.triangle.sevice;

import com.epam.triangle.entity.Point2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinearFunctionCheacker implements FunctionMatchesCheasker {

    private static final Logger LOGGER = LogManager.getLogger(LinearFunctionCheacker.class);


    private Point2D pointOne;
    private  Point2D pointTwo;

    public LinearFunctionCheacker(Point2D pointOne, Point2D pointTwo){
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
    }



    private double calculateK()  {

        double k= (pointTwo.getY() - pointOne.getY())
                  /(pointTwo.getX() - pointOne.getX());
        return k;
    }

    private double calculateB()  {
        double k = calculateK();
        double b = pointTwo.getY() -k*pointTwo.getX();
        return b;
    }

    @Override
    public boolean matches(Point2D point)  {
        double k = calculateK();
        double b = calculateB();
        return point.getY() == point.getX()*k + b;
    }
}
