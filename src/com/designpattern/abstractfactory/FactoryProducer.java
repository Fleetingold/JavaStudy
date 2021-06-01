package com.designpattern.abstractfactory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String choice) {
		// TODO Auto-generated method stub
		if(choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if(choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}

}
