package com.designpattern.facade;

import com.designpattern.factory.Circle;
import com.designpattern.factory.Rectangle;
import com.designpattern.factory.Shape;
import com.designpattern.factory.Square;

public class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape square;
	
	public ShapeMaker() {
		this.circle = new Circle();
		this.rectangle = new Rectangle();
		this.square = new Square();
	}

	public void drawCircle() {
		// TODO Auto-generated method stub
		circle.draw();
	}

	public void drawRectangle() {
		// TODO Auto-generated method stub
		rectangle.draw();
	}

	public void drawSquare() {
		// TODO Auto-generated method stub
		square.draw();
	}
}
