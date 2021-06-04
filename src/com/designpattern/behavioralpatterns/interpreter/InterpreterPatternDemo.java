package com.designpattern.behavioralpatterns.interpreter;

public class InterpreterPatternDemo {
	
	//规则: Robert 和 John 是男性
	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpress("Robert");
		Expression john = new TerminalExpress("John");
		return new OrExpression(robert, john);
	}

	//规则: Julie 是一个已婚的女性
	public static Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpress("Julie");
		Expression married = new TerminalExpress("Married");
		return new AndExpression(julie, married);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		
		System.out.println("Josin is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
	}
}
