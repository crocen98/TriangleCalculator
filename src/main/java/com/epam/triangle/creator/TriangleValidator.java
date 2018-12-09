package com.epam.triangle.creator;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;
import com.epam.triangle.sevice.FunctionMatchesCheasker;
import com.epam.triangle.sevice.LinearFunctionCheacker;

public class TriangleValidator {
    public boolean isValid(Point2D[] points) throws CannotCalculateFunctionsCoefficiensException {
        if(points.length !=3){
            return false;
        }

        Point2D pointOne = points[0];
        Point2D pointTwo = points[1];
        Point2D pointTree = points[2];

        if(pointOne.equals(pointTwo)
                ||pointOne.equals(pointTree)
                || pointTwo.equals(pointTree)){
            return false;
        }
        FunctionMatchesCheasker cheasker = new LinearFunctionCheacker(pointOne,pointTwo);
        return !cheasker.matches(pointTree);
    }
}
