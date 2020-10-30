package com.mystudy.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class JavaFunctionalInterfaceStudy01 {
	/**
	 * 	JDK 1.8 之前已有的函数式接口:
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
	 *	JDK 1.8 新增加的函数接口：
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
		// n 是一个参数传递到 Predicate 接口的 test 方法
		// n 如果存在则 test 方法返回 true
		
		System.out.println("输出所有数据:");
		
		eval(list, n->true);
		
		// Predicate<Integer> predicate1 = n -> n%2 == 0
		// n 是一个参数传递到 Predicate 接口的 test 方法
		// 如果 n%2 为 0 test 方法返回 true
		
		System.out.println("输出所有偶数:");
		eval(list, n-> n%2 == 0 );
	        
		// Predicate<Integer> predicate2 = n -> n > 3
		// n 是一个参数传递到 Predicate 接口的 test 方法
		// 如果 n 大于 3 test 方法返回 true
	        
		System.out.println("输出大于 3 的所有数字:");
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