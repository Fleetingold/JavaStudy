package com.mystudy;

import java.util.Scanner;

public class TakeTicket {

	private static Scanner scanner;

	public static void main(String[] args) {
		//XXX ���Ż�
		scanner = new Scanner(System.in);
		int balance = 0;
		int amount = 0;
		final int price = 10;
		
		while(true)
		{
			System.out.println("��Ͷ�ң�");
			amount = scanner.nextInt();
			balance = balance + amount;
			if(balance >= price)
			{
				System.out.println("************");
				System.out.println("*Java�Ǽ���·*");
				System.out.println("***Ʊ��10Ԫ***");
				System.out.println("************");
				int rest = balance - price;
				//FIXME ���޸�
				if(rest>0)
				{
					System.out.println("����" + rest + "Ԫ");
				}
				balance = 0;
			}
		}
	}
}
