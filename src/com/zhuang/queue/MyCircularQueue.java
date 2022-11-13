package com.zhuang.queue;

public class MyCircularQueue<E> implements CircularQueue<E> {
	// 指向队头元素，默认为0
	private int front;
	// 指向队尾元素，默认为0
	private int rear;
	// 存放队列元素，默认为null
	private E[] circularQueueArray;
	// 队列最大容量，默认为0
	private int size;

	public MyCircularQueue(int capacity) {
		// 有一个没用的元素，所以这里加一
		size = capacity + 1;
		// 有一个没用的元素，所以这里加一
		circularQueueArray = (E[]) new Object[capacity + 1];
	}

	@Override
	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	// 判断队列是否已满
	public boolean isFull() {
		return ((rear + 1) % size) == front;
	}

	@Override
	// 获取队列元素个数
	public int size() {
		return (rear - front + size) % size;
	}

	@Override
	// 入队列
	public void enqueue(E element) {
		// 判断队列是否已满
		if (isFull()) {
			System.out.println("队列已满，插入失败：" + element);
			return;
		}
		// 入队列
		circularQueueArray[rear] = element;
		// 向后移
		rear = (rear + 1) % size;
	}

	@Override
	// 出队列
	public E dequeue() {
		// 判断队列是否为空
		if (isEmpty()) {
			System.out.println("队列已空，获取失败");
			return null;
		}
		// 出队列
		E element = circularQueueArray[front];
		// 向后移
		front = (front + 1) % size;
		return element;
	}

	@Override
	public String toString() {
		// 获取队列有效元素
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = front; i < front + size(); i++) {
			sb.append(" " + circularQueueArray[i % size] + " ");
		}
		sb.append("]");
		// 返回队列详细信息
		return "circularQueueArray{" + "front=" + front + ", rear=" + rear + ", elements=" + sb.toString()
				+ ", eleSize=" + size() + ", size=" + (size - 1) + // 有一个没用的元素，所以这里减一
				", isEmpty=" + isEmpty() + ", isFull=" + isFull() + '}';
	}
}
