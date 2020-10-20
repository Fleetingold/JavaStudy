package com.mystudy.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * Java��׼�⻹�ṩ��һ��java.util.Timer�࣬�����Ҳ���Զ���ִ������
 * ���ǣ�һ��Timer���Ӧһ��Thread�����ԣ�һ��Timerֻ�ܶ���ִ��һ�����񣬶����ʱ��������������Timer��
 * ��һ��ScheduledThreadPool�Ϳ��Ե��ȶ����ʱ����
 * ���ԣ�������ȫ������ScheduledThreadPoolȡ���ɵ�Timer��
 */
public class ScheduledThreadPoolStudy {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
		
		// 1���ִ��һ��������:
		ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
		
		// 2���ʼִ�ж�ʱ����ÿ3��ִ��:
		ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
		
		// 3���ʼִ�ж�ʱ������3��Ϊ���ִ��:
		ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
	}
}
