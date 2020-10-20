package com.mystudy.multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureStudy01 {

	public static void main(String[] args) throws Exception {
		// �����첽ִ������
		CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureStudy01::fetchPrice);
		//���ִ�гɹ�:
		cf.thenAccept((result) -> 
		{
			System.out.println("price: " + result);
		});
		//���ִ���쳣:
		cf.exceptionally((e) -> 
		{
			e.printStackTrace();
			return null;
		});
		// ���̲߳�Ҫ���̽���������CompletableFutureĬ��ʹ�õ��̳߳ػ����̹رգ�
		Thread.sleep(2000);
	}
	
	static Double fetchPrice()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {}
		if (Math.random() < 0.3)
		{
			throw new RuntimeException("fetch price failed!");
		}
		return 5 + Math.random() * 20;
	}
}
