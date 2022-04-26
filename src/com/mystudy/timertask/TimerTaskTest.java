package com.mystudy.timertask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		// 5s执行
		// timer.schedule(new MyTask(), 5000);
		// 马上执行任务,每隔2000执行一次
		timer.scheduleAtFixedRate(new MyTask(), new Date(), 2000);
		
		System.out.println("其他任务");
	}

}

// 定时任务,这是一个线程
class MyTask extends TimerTask {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("task execute " + new Date());
	}
}