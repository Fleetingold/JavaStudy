package com.mystudy;

/**
 * @author hy1
 *
 *	位运算:与、或、异或、非、左移、右移
 */
public class BitWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 60; /* 60 = 0011 1100 */
		int b = 13; /* 13 = 0000 1101 */
		int c = 0;
		
		// 与
		c = a & b;	/* 12 = 0000 1100 */
		System.out.println("a & b = " + c);
		
		// 或
		c = a | b;	/* 61 = 0011 1101 */
		System.out.println("a | b = " + c);
		
		// 异或
		c = a ^ b;	/* 49 = 0011 0001 */
		System.out.println("a ^ b = " + c);
		
		// 非
		c = ~a;	/* -61 = 1100 0011 */
		System.out.println("~a = " + c);
		
		// 左移
		c = a << 2;	/* 240 = 1111 0000 */
		System.out.println("a << b = " + c);
		
		// 右移
		c = a >> 2;	/* 15 = 1111 */
		System.out.println("a >> 2 = " + c);
		
		// 右移
		c = a >>> 2;	/* 15 = 0000 1111 */
		System.out.println("a >>> 2 = " + c);
	}

}
