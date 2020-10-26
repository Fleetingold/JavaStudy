package com.mystudy;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		if (i <= 0) {
			System.out.println("这里不会被执行!!!");
		} else {
			// 原始字符 'a' 装箱到 Character 对象 ch 中
			Character ch = 'a';
			System.out.println("ch = " + ch);
			
			// Unicode 字符表示形式
			char uniChar = '\u039A';
			System.out.println("uniChar = " + uniChar);
			
			byte c = 0x4a; /* c = 74 */
			System.out.println("c = " + c);
			
			char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b' };
			String helloString = new String(helloArray);
			System.out.println(helloString);
			System.out.println("Hello Java World!!!");
		}
	}
}
