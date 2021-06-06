package com.designpattern.j2ee;

public class CompositeEntityPatternDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		client.setData("Test", "Data");
		client.printData();
		client.setData("Second Test", "Data1");
		client.printData();
	}
}