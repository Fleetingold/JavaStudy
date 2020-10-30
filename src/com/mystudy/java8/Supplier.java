package com.mystudy.java8;

@FunctionalInterface
public interface Supplier<T> {
	T get();
}