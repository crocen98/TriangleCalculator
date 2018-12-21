package com.epam.triangle.observer.impl;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.observer.Observable;
import com.epam.triangle.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape2DObservable extends Shape2D implements Observable {
    public Shape2DObservable(long id, Point2D[] points) {
        super(id, points);
    }

    List<Observer> observers = new ArrayList<>();

    @Override
    public void setPoint(Point2D point, int pointNumber) {
        super.setPoint(point, pointNumber);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        long id = getId();
        for (Observer observer: this.observers){
            observer.handleEvent(id,this);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
}
