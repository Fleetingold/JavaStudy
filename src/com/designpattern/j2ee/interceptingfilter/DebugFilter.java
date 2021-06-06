package com.designpattern.j2ee.interceptingfilter;

public class DebugFilter implements Filter {
	@Override
	public void execute(String request) {
		// TODO Auto-generated method stub
		System.out.println("request log: " + request);
	}
}