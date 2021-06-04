package com.designpattern.behavioralpatterns.interpreter;

public class TerminalExpress implements Expression {
	
	private String data;

	public TerminalExpress(String data) {
		this.data = data;
	}

	@Override
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		if(context.contains(data)) {
			return true;
		}
		return false;
	}
}