package com.zhuang.queue;

public interface SequentialQueue<E> {
	// 入队
	void offer(E data);

	// 出队
	E poll();

	// 队头
	E peekFont();

	// 判断是否队空
	boolean isEmpty();

	// 判断是否队满
	boolean isFull();

	// 队大小
	int size();

	// 销毁队列
	boolean destoryQueue(MySequentialQueue<E> myQueue);

	// 清空队列
	MySequentialQueue<E> clearQueue(MySequentialQueue<E> myQueue);
}
