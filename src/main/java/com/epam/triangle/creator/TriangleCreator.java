package com.epam.triangle.creator;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TriangleCreator {
    private static final Logger LOGGER = LogManager.getLogger(Triangle.class);

    private Triangle create(Point2D[] points)  {
        TriangleValidator validator = new TriangleValidator();
        if(!validator.isValid(points)){
            LOGGER.warn("not valid data  for creating triangle: " + Arrays.toString(points));
            return null;
        }

        return new Triangle(points);

    }

    public List<Triangle> createList(List<Point2D[]> listOfPonts)  {
        List<Triangle> triangleList = new LinkedList<>();

        for (Point2D[] points: listOfPonts){
            Triangle triangle = create(points);
            if(triangle != null){
                triangleList.add(triangle);
            }
        }
        return triangleList;
    }
}
