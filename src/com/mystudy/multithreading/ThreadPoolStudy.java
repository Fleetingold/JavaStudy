package com.mystudy.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Java��׼���ṩ��ExecutorService�ӿڱ�ʾ�̳߳�
 * 
 * ��ΪExecutorServiceֻ�ǽӿڣ�Java��׼���ṩ�ļ�������ʵ�����У�
 * 
 * FixedThreadPool���߳����̶����̳߳أ�
 * CachedThreadPool���߳�����������̬�������̳߳أ�
 * SingleThreadExecutor�������߳�ִ�е��̳߳ء�
 * 
 * ������Щ�̳߳صķ���������װ��Executors������С�
 */
public class ThreadPoolStudy {

	public static void main(String[] args) {
		// �����̶���С���̳߳أ�
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// �ύ����
		executor.submit(() -> {});
		executor.submit(() -> {});
		executor.submit(() -> {});
		executor.submit(() -> {});
		executor.submit(() -> {});
	}
}
