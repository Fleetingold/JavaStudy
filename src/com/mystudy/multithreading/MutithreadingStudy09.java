package com.mystudy.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutithreadingStudy09 {

	public static void main(String[] args) {

	}
}

class Counter09
{
	private final Lock lock = new ReentrantLock();
	private int count = 0;
	
	public void add(int n)
	{
		lock.lock();
		try
		{
			setCount(getCount() + n);
		}
		finally
		{
			lock.unlock();
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

/*
 * 通过ReentrantLock和Condition实现了一个BlockingQueue
 */
class TaskQueue09
{
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	private Queue<String> queue = new LinkedList<>();
	
	public void addTask(String s)
	{
		lock.lock();
		try
		{
			queue.add(s);
			condition.signalAll();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	public String getTask() throws InterruptedException
	{
		lock.lock();
		try
		{
			while (queue.isEmpty())
			{
				condition.await();
			}
			return queue.remove();
		}
		finally
		{
			lock.unlock();
		}
	}
}