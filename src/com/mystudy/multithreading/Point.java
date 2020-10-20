package com.mystudy.multithreading;

import java.util.concurrent.locks.StampedLock;

public class Point {
	private final StampedLock stampedLock = new StampedLock();
	
	private double x;
	private double y;
	
	public void move(double deltaX, double deltaY)
	{
		long stamp = stampedLock.tryWriteLock(); //��ȡд��
		try
		{
			x += deltaX;
			y += deltaY;
		}
		finally
		{
			stampedLock.unlockWrite(stamp); // �ͷ�д��
		}
	}
	
	public double disranceFromOrigin()
	{
		long stamp = stampedLock.tryOptimisticRead(); // ���һ���ֹ۶���
		// ע���������д��벻��ԭ�Ӳ���
		// ����x,y = (100, 200)
		double currentX = x;
		// �˴��Ѷ�ȡ��x=100, ��x,y���ܱ�д�߳��޸�Ϊ(300, 400)
		double currentY = y;
		// �˴��Ѷ�ȡ��y, ���û��д��, ��ȡ����ȷ��(100, 200)
		//�����д�룬 ��ȡ�Ǵ����(100, 400)
		if(!stampedLock.validate(stamp))
		{ // ����ֹ۶����Ƿ�������д������
			stamp = stampedLock.readLock(); //��ȡһ�����۶���
			try
			{
				currentX = x;
				currentY = y;
			}
			finally
			{
				stampedLock.unlockRead(stamp);
			}
		}
		return Math.sqrt(currentX * currentX + currentY * currentY);
	}
}
