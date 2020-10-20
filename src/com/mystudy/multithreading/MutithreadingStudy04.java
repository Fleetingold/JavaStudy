package com.mystudy.multithreading;

public class MutithreadingStudy04 {

	public static void main(String[] args) throws InterruptedException {
		// 中断线程
		Thread t = new MyThread04();
		t.start();
		Thread.sleep(1); // 暂停1毫秒
		t.interrupt(); // 中断t线程
		t.join(); //等待t线程结束
		System.out.println("end");
	}
}

class MyThread04 extends Thread 
{
	public void run()
	{
		int n = 0;
		while (! isInterrupted()) 
		{
			n ++;
			System.out.println(n + " hello!");
		}
	}
}
