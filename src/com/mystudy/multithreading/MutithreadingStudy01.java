package com.mystudy.multithreading;

public class MutithreadingStudy01 {

	public static void main(String[] args) {
		//����һ����Thread����һ���Զ����࣬Ȼ��дrun()����:
		//Thread t = new MyThread();
		//������������Threadʵ��ʱ������һ��Runnableʵ����
		//Thread t = new Thread(new MyRunnable());
		//����������Java8�����lambda�﷨��һ����д��
		Thread t = new Thread(() -> 
		{
			System.out.println("start new thread!");
		}) ;
		
		t.start(); //�������߳�
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