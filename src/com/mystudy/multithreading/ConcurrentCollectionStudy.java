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
		
		// 针对List、Map、Set、Deque等，java.util.concurrent包也提供了对应的并发集合类
		// interface		non-thread-safe				thread-safe
		// List				ArrayList					CopyOnWriteArrayList
		// Map				HashMap						ConcurrentHashMap
		// Set				HashSet / TreeSet			CopyOnWriteArraySet
		// Queue			ArrayDeque / LinkedList		ArrayBlockingQueue / LinkedBlockingQueue
		// Deque			ArrayDeque / LinkedList		LinkedBlockingDeque
		
		// 使用这些并发集合与使用非线程安全的集合类完全相同。我们以ConcurrentHashMap为例：
		// ConcurrentHashMap 不识别？？？s
		Map<String, String> map = new ConcurrentHashMap<>();
		// 在不同的线程读写
		map.put("A", "1");
		map.put("B", "2");
		map.get("A");
		
		// 自己发挥CopyOnWriteArrayList
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
		// Java8中添加java.util.Stream包，用于实现类似于C#链式查询的效果。
		Stream<String> stream = list.parallelStream();
		stream.count();
		
		// 自己发挥
		Set<String> set = new CopyOnWriteArraySet<>();
		set.add("");
		
		// 自己发挥
		Queue<String> queue1 = new ArrayBlockingQueue<>(10);
		queue1.add("");
		Queue<String> queue2 = new LinkedBlockingQueue<>(10);
		queue2.add("");
		
		// 自己发挥
		Deque<String> deque = new LinkedBlockingDeque<String>();
		deque.add("");
	}
}
