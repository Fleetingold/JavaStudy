package com.mystudy.generics;

public class GenericMethodStudy01 {
	// ���ͷ��� printArray
	public static <E> void printArray( E[] inputArray ) {
		// �������Ԫ��
		for( E element : inputArray) {
			System.out.printf( "%s ", element);
		}
		System.out.println();
	}
	
	public static void main( String args[]) {
		// ������ͬ��������: Integer, Double �� Character
		Integer[] intArray = { 1, 2, 3, 4, 5};
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		
		System.out.println( "��������Ԫ��Ϊ:" );
		printArray(intArray); // ����һ����������
		
		System.out.println( "\n˫��������Ԫ��Ϊ:" );
		printArray(doubleArray); // ����һ��˫��������
		
		System.out.println( "\n�ַ�������Ԫ��Ϊ:" );
		printArray(charArray); // ����һ���ַ�������
	}
}
