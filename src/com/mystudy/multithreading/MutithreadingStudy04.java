package com.mystudy.multithreading;

public class MutithreadingStudy04 {

	public static void main(String[] args) throws InterruptedException {
		// �ж��߳�
		Thread t = new MyThread04();
		t.start();
		Thread.sleep(1); // ��ͣ1����
		t.interrupt(); // �ж�t�߳�
		t.join(); //�ȴ�t�߳̽���
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
