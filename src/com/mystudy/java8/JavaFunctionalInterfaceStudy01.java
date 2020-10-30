package com.mystudy.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class JavaFunctionalInterfaceStudy01 {
	/**
	 * 	JDK 1.8 ֮ǰ���еĺ���ʽ�ӿ�:
	 *	java.lang.Runnable
	 *	java.util.concurrent.Callable
	 *	java.security.PrivilegedAction
	 *	java.util.Comparator
	 *	java.io.FileFilter
	 *	java.nio.file.PathMatcher
	 *	java.lang.reflect.InvocationHandler
	 *	java.beans.PropertyChangeListener
	 *	java.awt.event.ActionListener
	 *	javax.swing.event.ChangeListener
	 *	
	 *	JDK 1.8 �����ӵĺ����ӿڣ�
	 *	java.util.function.*
	 *
	 *	BiConsumer<T,U>
	 *	BiFunction<T,U,R>
	 *	BinaryOperator<T>
	 *	BiPredicate<T,U>
	 *	BooleanSupplier
	 *	Consumer<T>
	 *	DoubleBinaryOperator
	 *	DoubleConsumer
	 *	DoubleFunction<R>
	 *	DoublePredicate
	 *	DoubleSupplier
	 *	DoubleToIntFunction
	 *	DoubleToLongFunction
	 *	DoubleUnaryOperator
	 *	Function<T,R>
	 *	IntBinaryOperator
	 *	IntConsumer
	 *	IntFunction<R>
	 *	IntPredicate
	 *	IntSupplier
	 *	IntToDoubleFunction
	 *	IntToLongFunction
	 *	IntUnaryOperator
	 *	LongBinaryOperator
	 *	LongConsumer
	 *	LongFunction<R>
	 *	LongPredicate
	 *	LongSupplier
	 *	LongToDoubleFunction
	 *	LongToIntFunction
	 *	LongUnaryOperator
	 *	ObjDoubleConsumer<T>
	 *	ObjIntConsumer<T>
	 *	ObjLongConsumer<T>
	 *	Predicate<T>
	 *	Supplier<T>
	 *	ToDoubleBiFunction<T,U>
	 *	ToDoubleFunction<T>
	 *	ToIntBiFunction<T,U>
	 *	ToIntFunction<T>
	 *	ToLongBiFunction<T,U>
	 *	ToLongFunction<T>
	 *	UnaryOperator<T>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GreetingService greetService1 = message -> System.out.println("Hello " + message);
		
		greetService1.sayMessage("Runoob");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// Predicate<Integer> predicate = n -> true
		// n ��һ���������ݵ� Predicate �ӿڵ� test ����
		// n ��������� test �������� true
		
		System.out.println("�����������:");
		
		eval(list, n->true);
		
		// Predicate<Integer> predicate1 = n -> n%2 == 0
		// n ��һ���������ݵ� Predicate �ӿڵ� test ����
		// ��� n%2 Ϊ 0 test �������� true
		
		System.out.println("�������ż��:");
		eval(list, n-> n%2 == 0 );
	        
		// Predicate<Integer> predicate2 = n -> n > 3
		// n ��һ���������ݵ� Predicate �ӿڵ� test ����
		// ��� n ���� 3 test �������� true
	        
		System.out.println("������� 3 ����������:");
		eval(list, n-> n > 3 );
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}
}

@FunctionalInterface
interface GreetingService {
	void sayMessage(String message);
}