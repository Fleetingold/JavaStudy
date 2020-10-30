package com.mystudy.java8;

import java.util.Arrays;
import java.util.List;

public class JavaMethodReferenceStudy02 {
	public static void main(String[] args) {
		//����������
		final Car car = Car.create( Car::new );
		final List<Car> cars = Arrays.asList( car );
		
		//��̬��������
		cars.forEach( Car::collide );
		
		//�ض�����������ķ�������
		cars.forEach( Car::repair);
		
		//�ض�����ķ�������
		final Car police = Car.create( Car::new );
		cars.forEach( police::follow);
	}
}

class Car {
	//Supplier��jdk1.8�Ľӿڣ������lambdaһ��ʹ����
	public static Car create(final Supplier<Car> supplier) {
		return supplier.get();
	}
	
	public static void collide(final Car car) {
		System.out.println("Collided " + car.toString());
	}
	
	public void follow(final Car another) {
		System.out.println("Following the " + another.toString());
	}
	
	public void repair() {
		System.out.println("Repaired " + this.toString());
	}
}