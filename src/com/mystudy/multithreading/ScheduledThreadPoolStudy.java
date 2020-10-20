package com.mystudy.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * Java标准库还提供了一个java.util.Timer类，这个类也可以定期执行任务，
 * 但是，一个Timer会对应一个Thread，所以，一个Timer只能定期执行一个任务，多个定时任务必须启动多个Timer，
 * 而一个ScheduledThreadPool就可以调度多个定时任务，
 * 所以，我们完全可以用ScheduledThreadPool取代旧的Timer。
 */
public class ScheduledThreadPoolStudy {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
		
		// 1秒后执行一次性任务:
		ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
		
		// 2秒后开始执行定时任务，每3秒执行:
		ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
		
		// 3秒后开始执行定时任务，以3秒为间隔执行:
		ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
	}
}
