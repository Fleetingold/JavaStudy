package com.mystudy.timertask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		// 5sִ��
		// timer.schedule(new MyTask(), 5000);
		// ����ִ������,ÿ��2000ִ��һ��
		timer.scheduleAtFixedRate(new MyTask(), new Date(), 2000);
		
		System.out.println("��������");
	}

}

// ��ʱ����,����һ���߳�
class MyTask extends TimerTask {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task execute " + new Date());
	}
}