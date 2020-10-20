package com.mystudy.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolStudy {

	public static void main(String[] args) {
		// ����һ���̶���С���̳߳�:
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // �ر��̳߳�:
        es.shutdown();
	}
}
