package com.mystudy.java8;

public class JavaLambdaStudy04 {
	public static void main(String[] args) {
		int num = 1;
		Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
		s.convert(2);

		//±®¥Ì–≈œ¢£∫Local variable num defined in an enclosing scope must be final or effectively
		//num = 5;
	}
	
	public interface Converter<T1, T2> {
		void convert(int i);
	}
}
