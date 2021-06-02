package com.designpattern.bridge;

public abstract class Shape {
	protected DrawAPI drawAPI;
	protected Shape(DrawAPI drawAPI) {
		// TODO Auto-generated constructor stub
		this.drawAPI = drawAPI;
	}
	public abstract void draw();
}