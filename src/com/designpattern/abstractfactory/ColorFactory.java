package com.designpattern.abstractfactory;

public class ColorFactory extends AbstractFactory {

	@Override
	protected Color getColor(String colorType) {
		// TODO Auto-generated method stub
		if(colorType == null) {
			return null;
		}
		if(colorType.equalsIgnoreCase("RED")) {
			return new Red();
		} else if(colorType.equalsIgnoreCase("GREEN")) {
			return new Green();
		} else if(colorType.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		return null;
	}

}
