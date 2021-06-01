package com.designpattern.factory;

public class Square extends Shape {

	public Square() {
		// TODO Auto-generated constructor stub
		type = "Square";
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Inside Square:draw() method");
	}
}
