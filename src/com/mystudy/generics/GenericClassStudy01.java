package com.mystudy.generics;

class Box<T> {
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}

public class GenericClassStudy01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
		
		integerBox.add(new Integer(10));
		stringBox.add(new String("����̳�"));
		
		System.out.printf("����ֵΪ :%d\n\n", integerBox.get());
		System.out.printf("�ַ���Ϊ :%s\n", stringBox.get());
	}

}
