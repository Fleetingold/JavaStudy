package com.designpattern.proxy;

public class RealImage implements Image {
	
	private String fileName;

	public RealImage(String fileName) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying " + fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading " + fileName);
	}
}
