package com.zhuang.queue;

public class MyQueueTest {

	public static void main(String[] args) {
		test02();
	}

	public static void test02() {
		MyPriorityQueue myPriorityQueue = new MyPriorityQueue(5);
		myPriorityQueue.offer(30);
		myPriorityQueue.offer(50);
		myPriorityQueue.offer(10);
		myPriorityQueue.offer(40);
		myPriorityQueue.offer(20);
		// 获取最队列队头 也是最小值
		System.out.println(myPriorityQueue.peekMin());
		myPriorityQueue.display(myPriorityQueue);
	}

	public static void test01() {
		MyQueue<Integer> myQueue = new MyQueue<Integer>(5);
		myQueue.offer(10);
		myQueue.offer(20);
		myQueue.offer(30);
		myQueue.offer(40);

		myQueue.poll();
		myQueue.poll();
		myQueue.poll();

		myQueue.offer(50);
		myQueue.offer(60);
		myQueue.offer(70);

		myQueue.display(myQueue);
	}

}
