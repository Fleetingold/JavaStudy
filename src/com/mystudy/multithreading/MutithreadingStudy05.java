package com.mystudy.multithreading;

public class MutithreadingStudy05 
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread t = new MyThread05();
		t.start();
		Thread.sleep(1000);
		t.interrupt(); // �ж�t�߳�
		t.join(); //�ȴ�t�߳̽���
		System.out.println("end");
	}
}

class MyThread05 extends Thread
{
	public void run()
	{
		Thread hello = new HelloThread05();
		hello.start(); // ����hello�߳�
		try
		{
			hello.join(); //�ȴ�hello�߳̽���
		}
		catch (InterruptedException e)
		{
			System.out.println("interrupted!");
		}
		hello.interrupt();
	}
}

class HelloThread05 extends Thread
{
	public void run()
	{
		int n = 0;
		while (!isInterrupted())
		{
			n++;
			System.out.println(n + " hello!");
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}
}