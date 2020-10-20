package com.mystudy.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Java标准库提供了ExecutorService接口表示线程池
 * 
 * 因为ExecutorService只是接口，Java标准库提供的几个常用实现类有：
 * 
 * FixedThreadPool：线程数固定的线程池；
 * CachedThreadPool：线程数根据任务动态调整的线程池；
 * SingleThreadExecutor：仅单线程执行的线程池。
 * 
 * 创建这些线程池的方法都被封装到Executors这个类中。
 */
public class ThreadPoolStudy {

	public static void main(String[] args) {
		// 创建固定大小的线程池：
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// 提交任务：
		executor.submit(() -> {});
		executor.submit(() -> {});
		executor.submit(() -> {});
		executor.submit(() -> {});
		executor.submit(() -> {});
	}
}
