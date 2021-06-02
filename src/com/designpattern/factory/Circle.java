package com.designpattern.factory;

public class Circle extends Shape {
	private String color;
	private int x, y, radius;
	
	public Circle() {
		// TODO Auto-generated constructor stub
		type = "Circle";
	}
	
	public Circle(String color) {
		// TODO Auto-generated constructor stub
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if(x == 0 || y == 0 || radius == 0) {
			System.out.println("Inside Circle::draw() method");	
		} else {
			System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y : " + y + ", radius :" + radius);
		}
	}
}
