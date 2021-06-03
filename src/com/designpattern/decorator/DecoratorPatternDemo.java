package com.designpattern.decorator;

import com.designpattern.factory.Circle;
import com.designpattern.factory.Rectangle;
import com.designpattern.factory.Shape;

public class DecoratorPatternDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape circle = new Circle();
		ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
		ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
		
		System.out.println("Circle with normal border");
		circle.draw();
		
		System.out.println("\nCircle of red border");
		redCircle.draw();
		
		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
