package com.designpattern.flyweight;

import com.designpattern.factory.Circle;

public class FlyWeightPatternDemo {
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i < 20; ++i) {
			Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}

	private static String getRandomColor() {
		// TODO Auto-generated method stub
		return colors[(int)(Math.random()*colors.length)];
	}
	
	private static int getRandomX() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*100);
	}
	
	private static int getRandomY() {
		// TODO Auto-generated method stub
		return (int)(Math.random()*100);
	}
}
