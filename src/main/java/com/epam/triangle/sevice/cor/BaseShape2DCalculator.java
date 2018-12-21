package com.epam.triangle.sevice.cor;


import com.epam.triangle.entity.Shape2D;

public abstract class BaseShape2DCalculator implements Shape2DCalculatorChain {

     private Shape2DCalculatorChain next;


     protected Double checkNextPerimetr(Shape2D shape){
          if(next == null){
               return null;
          } else {
               return next.perimeter(shape);
          }
     }

     protected Double checkNextSquare(Shape2D shape){
          if(next == null){
               return null;
          } else {
               return next.square(shape);
          }
     }


     @Override
     public Shape2DCalculatorChain linkWith(Shape2DCalculatorChain chain){
          next = chain;
          return next;
     }
}
