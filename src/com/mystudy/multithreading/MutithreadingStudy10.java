package com.mystudy.multithreading;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MutithreadingStudy10 {

	public static void main(String[] args) {

	}
}

class Counter10
{
	private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
	private final Lock rlock = rwlock.readLock();
	private final Lock wlock = rwlock.writeLock();
	private int[] counts = new int[10];
	
	public void inc(int index)
	{
		wlock.lock(); // ¼ÓÐ´Ëø
		try
		{
			counts[index] += 1;
		}
		finally
		{
			wlock.unlock();
		}
	}
	
	public int[] get()
	{
		rlock.lock();
		try
		{
			return Arrays.copyOf(counts, counts.length);
		}
		finally
		{
			rlock.unlock();
		}
	}
}