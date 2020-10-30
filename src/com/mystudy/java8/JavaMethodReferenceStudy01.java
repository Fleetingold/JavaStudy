package com.mystudy.java8;

import java.util.ArrayList;
import java.util.List;

public class JavaMethodReferenceStudy01 {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		
		names.add("Google");
		names.add("Runoob");
		names.add("Taobao");
		names.add("Baidu");
		names.add("Sina");
		
		names.forEach(System.out::println);
	}
}
