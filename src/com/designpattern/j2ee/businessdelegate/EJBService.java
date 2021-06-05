package com.designpattern.j2ee.businessdelegate;

public class EJBService implements BusinessService {

	@Override
	public void doProcessing() {
		// TODO Auto-generated method stub
		System.out.println("Processing task by invoking EJB Service");
	}

}
