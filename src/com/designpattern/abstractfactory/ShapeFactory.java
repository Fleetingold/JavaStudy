package com.designpattern.abstractfactory;

import com.designpattern.factory.Circle;
import com.designpattern.factory.Rectangle;
import com.designpattern.factory.Shape;
import com.designpattern.factory.Square;

public class ShapeFactory extends AbstractFactory {

	@Override
	protected Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		if(shapeType == null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
	
}
