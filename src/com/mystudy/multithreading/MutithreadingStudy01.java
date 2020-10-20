package com.mystudy.multithreading;

public class MutithreadingStudy01 {

	public static void main(String[] args) {
		//方法一：从Thread派生一个自定义类，然后覆写run()方法:
		//Thread t = new MyThread();
		//方法二：创建Thread实例时，传入一个Runnable实例：
		//Thread t = new Thread(new MyRunnable());
		//方法三：用Java8引入的lambda语法进一步简写：
		Thread t = new Thread(() -> 
		{
			System.out.println("start new thread!");
		}) ;
		
		t.start(); //启动新线程
	}
}

class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println("start new thread!");
	}
}

class MyRunnable implements Runnable
{
	@Override
	public void run()
	{
		System.out.println("start new thread!");
	}
}