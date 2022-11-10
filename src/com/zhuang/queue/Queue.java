package com.zhuang.queue;

public interface Queue<E> {
	void offer(E data);
	
	E poll();
	
	E peekFont();
	
	boolean isEmpty();
	
	boolean isFull();
	
	int size();
}
