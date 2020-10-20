package com.mystudy.multithreading;

public class MutithreadingStudy07 {

	public static void main(String[] args) throws Exception {
		Thread add = new AddThread();
		Thread dec = new DecThread();
		
		add.start();
		dec.start();
		add.join();
		dec.join();
		System.out.print(Counter07.count);
	}
}

class Counter07
{
	public static final Object lock = new Object();
	public static int count = 0;
}

class AddThread extends Thread
{
	public void run()
	{
		for (int i=0; i<10000; i++) 
		{
			synchronized(Counter07.lock)
			{ //��ȡ��
				Counter07.count +=1;				
			} //�ͷ���
		}
	}
}

class DecThread extends Thread
{
	public void run()
	{
		for (int i=0; i<10000; i++)
		{
			synchronized(Counter07.lock)
			{ //��ȡ��
				Counter07.count -= 1;
			} //�ͷ���
		}
	}
}