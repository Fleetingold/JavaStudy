package com.designpattern.behavioralpatterns.visitor;

public class VisitorPatternDemo {
	public static void main(String[] args) {
		
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartDesplayVisitor());
	}
}