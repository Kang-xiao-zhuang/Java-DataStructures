package com.zhuang.queue;

public interface CircularQueue<E> {

	boolean isEmpty();

	boolean isFull();

	int size();

	void enqueue(E element);

	E dequeue();

}
