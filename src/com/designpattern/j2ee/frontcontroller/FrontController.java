package com.designpattern.j2ee.frontcontroller;

public class FrontController {

	private Dispather dispather;
	
	public FrontController() {
		// TODO Auto-generated constructor stub
		dispather = new Dispather();
	}
	
	private boolean isAuthenticUser() {
		System.out.println("User is authenticated successfully.");
		return true;
	}
	
	private void trackRequest(String request) {
		System.out.println("Page requested: " + request);
	}
	
	public void dispatchRequest(String request) {
		//记录每一个请求
		trackRequest(request);
		//对用户进行身份验证
		if(isAuthenticUser()) {
			dispather.dispatch(request);
		}
	}
}