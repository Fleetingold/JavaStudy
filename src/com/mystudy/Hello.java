package com.mystudy;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		if (i <= 0) {
			System.out.println("���ﲻ�ᱻִ��!!!");
		} else {
			// ԭʼ�ַ� 'a' װ�䵽 Character ���� ch ��
			Character ch = 'a';
			System.out.println("ch = " + ch);
			
			// Unicode �ַ���ʾ��ʽ
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
