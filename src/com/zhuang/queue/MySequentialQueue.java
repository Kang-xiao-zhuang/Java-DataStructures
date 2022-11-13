package com.zhuang.queue;

import java.util.Arrays;

/**
 * 
 * @ClassName: MyQueue
 * @Description:自定义队列
 * @author: KangXiaoZhuang
 * @date: 2022年11月13日 上午11:19:33
 */
public class MySequentialQueue<E> implements SequentialQueue<E> {
	// 队列大小
	private int size;
	// 数组实现
	private E[] queueArray;
	// 队头
	private int front;
	// 队尾
	private int rear;
	// 队内元素
	private int item;

	// 初始化队列
	@SuppressWarnings("unchecked")
	public MySequentialQueue(int s) {
		size = s;
		queueArray = (E[]) new Object[size];
		front = 0;
		rear = -1;
		item = 0;
	}

	@Override
	public void offer(E e) {
		if (rear == size - 1) {
			rear = -1;
		}
		queueArray[++rear] = e;
		item++;
	}

	@Override
	public E poll() {
		E temp = queueArray[front++];
		if (front == size) {
			front = 0;
		}
		item--;
		return temp;
	}

	@Override
	public E peekFont() {
		return queueArray[front];
	}

	@Override
	public boolean isEmpty() {
		return item == 0;
	}

	@Override
	public boolean isFull() {
		if (item == 0 && size == 0) {
			return false;
		}
		return item == size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean destoryQueue(MySequentialQueue<E> myQueue) {
		myQueue.size = 0;
		myQueue.queueArray = null;
		myQueue.front = 0;
		myQueue.rear = -1;
		myQueue.item = 0;
		return true;
	}

	@Override
	public MySequentialQueue<E> clearQueue(MySequentialQueue<E> myQueue) {
		for (int i = 0; i < myQueue.queueArray.length; i++) {
			myQueue.queueArray[i] = null;
		}
		return myQueue;
	}

	public void display(MySequentialQueue<E> queue) {
		while (!queue.isEmpty()) {
			E e = queue.poll();
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		// 获取队列有效元素
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = front; i <= rear; i++) {
			sb.append(" " + queueArray[i] + " ");
		}
		sb.append("]");
		// 返回队列详细信息
		return "MySequentialQueue{" + "front=" + front + ", rear=" + rear + ", elements=" + sb.toString() + ", eleSize="
				+ size() + ", size=" + size + ", isEmpty=" + isEmpty() + ", isFull=" + isFull() + '}';
	}
}
