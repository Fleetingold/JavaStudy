package com.mystudy;

import java.util.Scanner;

public class TakeTicket {

	private static Scanner scanner;

	public static void main(String[] args) {
		//XXX 待优化
		scanner = new Scanner(System.in);
		int balance = 0;
		int amount = 0;
		final int price = 10;
		
		while(true)
		{
			System.out.println("请投币：");
			amount = scanner.nextInt();
			balance = balance + amount;
			if(balance >= price)
			{
				System.out.println("************");
				System.out.println("*Java城际铁路*");
				System.out.println("***票价10元***");
				System.out.println("************");
				int rest = balance - price;
				//FIXME 待修改
				if(rest>0)
				{
					System.out.println("找零" + rest + "元");
				}
				balance = 0;
			}
		}
	}
}
