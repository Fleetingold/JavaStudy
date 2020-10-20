package com.mystudy.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * �������ύһ��Callable��������ǻ�ͬʱ���һ��Future����
 * Ȼ�����������߳�ĳ��ʱ�̵���Future�����get()�������Ϳ��Ի���첽ִ�еĽ����
 * �ڵ���get()ʱ������첽�����Ѿ���ɣ����Ǿ�ֱ�ӻ�ý����
 * ����첽����û����ɣ���ôget()��������ֱ��������ɺ�ŷ��ؽ����
 * 
 * һ��Future<V>�ӿڱ�ʾһ��δ�����ܻ᷵�صĽ����������ķ����У�
 * get()����ȡ��������ܻ�ȴ���
 * get(long timeout, TimeUnit unit)����ȡ�������ֻ�ȴ�ָ����ʱ�䣻
 * cancel(boolean mayInterruptIfRunning)��ȡ����ǰ����
 * isDone()���ж������Ƿ�����ɡ�
 */
public class FutureStudy {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// ExecutorService.submit()������������һ��Future���ͣ�һ��Future���͵�ʵ������һ��δ���ܻ�ȡ����Ķ���
		ExecutorService executor = Executors.newFixedThreadPool(4); 
		// ��������:
		Callable<String> task = new FTask();
		// �ύ���񲢻��Future:
		Future<String> future = executor.submit(task);
		// ��Future��ȡ�첽ִ�з��صĽ��:
		String result = future.get(); // ��������
		System.out.println(result);
	}
}

class FTask implements Callable<String> {
    public String call() throws Exception {
        return longTimeCalculation(); 
    }

	private String longTimeCalculation() {
		return null;
	}
}