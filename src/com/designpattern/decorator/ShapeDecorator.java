package com.designpattern.decorator;

import com.designpattern.factory.Shape;

public abstract class ShapeDecorator extends Shape {
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		decoratedShape.draw();
	}
}
