package com.mystudy.java8;

/**
 * 
 * 	ΪʲôҪ��������ԣ�
 * 	���ȣ�֮ǰ�Ľӿ��Ǹ�˫�н����ô�����������������������̣�ȱ���ǣ�����Ҫ�޸Ľӿ�ʱ����Ҫ�޸�ȫ��ʵ�ָýӿڵ��࣬
 * 	Ŀǰ�� java 8 ֮ǰ�ļ��Ͽ��û�� foreach ������ͨ�����뵽�Ľ���취����JDK�����صĽӿ�����µķ�����ʵ�֡�Ȼ����
 * 	�����Ѿ������İ汾����û���ڸ��ӿ�����·�����ͬʱ��Ӱ�����е�ʵ�֡�����������Ĭ�Ϸ�����
 * 	���ǵ�Ŀ����Ϊ�˽���ӿڵ��޸������е�ʵ�ֲ����ݵ����⡣
 * 
 */
public class JavaInterfaceDefaultMethodStudy01 {
	public static void main(String[] args) {
		Vehicle vehicle = new NewCar();
		vehicle.print();
	}
}

interface Vehicle {
	default void print() {
		System.out.println("����һ������");
	}
	
	static void blowHorn() {
		System.out.println("�����ȣ�����");
	}
}

interface FourWheeler {
	default void print() {
		System.out.println("����һ�����ֳ���");
	}
}

class NewCar implements Vehicle, FourWheeler {
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("����һ��������");
	}
}