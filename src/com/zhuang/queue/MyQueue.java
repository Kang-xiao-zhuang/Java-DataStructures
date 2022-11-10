package com.zhuang.queue;

public class MyQueue<E> implements Queue<E> {
	private int size;
	private E[] queueArray;
	private int font;
	private int rear;
	private int item;

	public MyQueue(int s) {
		size = s;
		queueArray = (E[]) new Object[size];
		font = 0;
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
		E temp = queueArray[font++];
		if (font == size) {
			font = 0;
		}
		item--;
		return temp;
	}

	@Override
	public E peekFont() {
		return queueArray[font];
	}

	@Override
	public boolean isEmpty() {
		return item == 0;
	}

	@Override
	public boolean isFull() {
		return item == size;
	}

	@Override
	public int size() {
		return size;
	}

	public void display(MyQueue<E> queue) {
		while (!queue.isEmpty()) {
			E e = queue.poll();
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
