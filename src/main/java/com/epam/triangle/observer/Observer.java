package com.epam.triangle.observer;

import com.epam.triangle.entity.Shape2D;

public interface Observer {
    void handleEvent(long id, Shape2D shape);
}
