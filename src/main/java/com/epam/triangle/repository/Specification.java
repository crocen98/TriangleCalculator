package com.epam.triangle.repository;

public interface Specification<T> {
    boolean specify(T object);
}