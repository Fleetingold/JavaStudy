package com.mystudy.multithreading;

public class MutithreadingStudy06 {

	public static void main(String[] args) throws InterruptedException {
		HelloThread06 t = new HelloThread06();
		t.start();
		Thread.sleep(1);
		t.running = false;
	}
}

class HelloThread06 extends Thread
{
	public volatile boolean running = true;
	public void run()
	{
		int n = 0;
		while (running)
		{
			n ++;
			System.out.println(n + " hello!");
		}
		System.out.println("end!");
	}
}