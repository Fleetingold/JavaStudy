package com.designpattern.j2ee.frontcontroller;

public class Dispather {
	private StudentView studentView;
	private HomeView homeView;
	
	public Dispather() {
		studentView = new StudentView();
		homeView = new HomeView();
	}
	
	public void dispatch(String request) {
		if(request.equalsIgnoreCase("STUDENT")) {
			studentView.show();
		} else {
			homeView.show();
		}
	}
}
