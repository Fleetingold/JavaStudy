package com.mystudy.multithreading;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/*
 * Java 7��ʼ������һ���µ�Fork/Join�̳߳أ�������ִ��һ����������񣺰�һ���������ɶ��С������ִ�С�
 * 
 * Fork/Join�̳߳���Java��׼���о���Ӧ�á�
 * Java��׼���ṩ��java.util.Arrays.parallelSort(array)���Խ��в�������
 * ����ԭ������ڲ�ͨ��Fork/Join�Դ�����ֲ���в��������ڶ��CPU�ϾͿ��Դ�����������ٶȡ�
 */
public class ForkJoinStudy {

	public static void main(String[] args) {
		// ����2000���������ɵ�����:
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);
        // fork/join:
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
	}
	
	static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }
}

class SumTask extends RecursiveTask<Long> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int THRESHOLD = 500;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // ��������㹻С,ֱ�Ӽ���:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
                // ������������ٶ�:
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            return sum;
        }
        // ����̫��,һ��Ϊ��:
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        invokeAll(subtask1, subtask2);
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}