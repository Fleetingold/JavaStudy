package com.mystudy.multithreading;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class ConcurrentCollectionStudy {

	public static void main(String[] args) {
		// ArrayBlockingQueue
		
		// ���List��Map��Set��Deque�ȣ�java.util.concurrent��Ҳ�ṩ�˶�Ӧ�Ĳ���������
		// interface		non-thread-safe				thread-safe
		// List				ArrayList					CopyOnWriteArrayList
		// Map				HashMap						ConcurrentHashMap
		// Set				HashSet / TreeSet			CopyOnWriteArraySet
		// Queue			ArrayDeque / LinkedList		ArrayBlockingQueue / LinkedBlockingQueue
		// Deque			ArrayDeque / LinkedList		LinkedBlockingDeque
		
		// ʹ����Щ����������ʹ�÷��̰߳�ȫ�ļ�������ȫ��ͬ��������ConcurrentHashMapΪ����
		// ConcurrentHashMap ��ʶ�𣿣���s
		Map<String, String> map = new ConcurrentHashMap<>();
		// �ڲ�ͬ���̶߳�д
		map.put("A", "1");
		map.put("B", "2");
		map.get("A");
		
		// �Լ�����CopyOnWriteArrayList
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("");
		list.isEmpty();
		list.size();
		list.contains("");
		list.get(0);
		list.forEach(it -> 
		{
			
		});
		list.remove(0);
		list.clear();
		// Java8�����java.util.Stream��������ʵ��������C#��ʽ��ѯ��Ч����
		Stream<String> stream = list.parallelStream();
		stream.count();
		
		// �Լ�����
		Set<String> set = new CopyOnWriteArraySet<>();
		set.add("");
		
		// �Լ�����
		Queue<String> queue1 = new ArrayBlockingQueue<>(10);
		queue1.add("");
		Queue<String> queue2 = new LinkedBlockingQueue<>(10);
		queue2.add("");
		
		// �Լ�����
		Deque<String> deque = new LinkedBlockingDeque<String>();
		deque.add("");
	}
}
