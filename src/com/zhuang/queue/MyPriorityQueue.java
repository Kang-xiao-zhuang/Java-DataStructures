package com.zhuang.queue;

public class MyPriorityQueue {
	private int size;
	private long[] queueArray;
	private int item;

	public MyPriorityQueue(int s) {
		size = s;
		queueArray = new long[size];
		item = 0;
	}

	public void offer(long data) {
		int j;
		if (item == 0) {
			queueArray[item++] = data;
		} else { // item>0
			for (j = item - 1; j >= 0; j--) {
				// 数组排序
				if (data > queueArray[j]) {
					queueArray[j + 1] = queueArray[j];
				} else {
					break;
				}
			}
			queueArray[j + 1] = data;
			item++;
		}
	}

	public long poll() {
		return queueArray[--item];
	}

	public long peekMin() {
		return queueArray[item - 1];
	}

	public boolean isEmpty() {
		return item == 0;
	}

	public boolean isFull() {
		return item == size;
	}

	public void display(MyPriorityQueue myPriorityQueue) {
		while (!myPriorityQueue.isEmpty()) {
			long e = myPriorityQueue.poll();
			System.out.print(e + " ");
		}
		System.out.println("");
	}
}
