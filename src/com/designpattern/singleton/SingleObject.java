package com.designpattern.singleton;

public class SingleObject {

	//���� SingleObject ��һ������
	private static SingleObject instance = new SingleObject();
	
	//�ù��췽��Ϊ private, ��������Ͳ��ᱻʵ����
	private SingleObject() {}
	
	//��ȡΨһ���õĶ���
	public static SingleObject getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.print("Hello World!");
	}

}
