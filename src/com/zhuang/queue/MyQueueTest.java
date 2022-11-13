package com.zhuang.queue;

public class MyQueueTest {

	public static void main(String[] args) {
		// test01();
		// test02();
		test03();
	}

	public static void test01() {
		MySequentialQueue<Integer> myQueue1 = new MySequentialQueue<Integer>(5);
		myQueue1.offer(10);
		myQueue1.offer(20);
		myQueue1.offer(30);
		myQueue1.offer(40);
		System.out.println("队头:" + myQueue1.peekFont());
		System.out.println(myQueue1);
		System.out.println("----------------------------------------------");
		MySequentialQueue<Integer> myQueue2 = new MySequentialQueue<Integer>(5);
		myQueue2.offer(10);
		myQueue2.offer(20);
		myQueue2.offer(30);
		myQueue2.offer(40);
		myQueue2.poll();
		myQueue2.poll();
		myQueue2.poll();
		System.out.println("队头:" + myQueue2.peekFont());
		System.out.println(myQueue2);
		System.out.println("----------------------------------------------");
		MySequentialQueue<Integer> myQueue3 = new MySequentialQueue<Integer>(5);
		myQueue3.offer(10);
		myQueue3.offer(20);
		myQueue3.offer(30);
		myQueue3.offer(40);
		myQueue3.poll();
		myQueue3.poll();
		myQueue3.poll();
		myQueue3.poll();
		System.out.println("队头:" + myQueue3.peekFont());
		System.out.println(myQueue3);
		System.out.println("----------------------------------------------");
		MySequentialQueue<String> myQueue4 = new MySequentialQueue<String>(5);
		myQueue4.offer("A");
		myQueue4.offer("B");
		myQueue4.offer("C");
		myQueue4.offer("D");
		myQueue4.offer("E");
		System.out.println("队头:" + myQueue4.peekFont());
		System.out.println(myQueue4);
		System.out.println("----------------------------------------------");
		MySequentialQueue<String> myQueue5 = new MySequentialQueue<String>(5);
		myQueue5.offer("A");
		myQueue5.offer("B");
		myQueue5.offer("C");
		myQueue5.offer("D");
		myQueue5.offer("E");
		System.out.println(myQueue5);
		System.out.println("执行销毁队列操作");
		myQueue5.destoryQueue(myQueue5);
		System.out.println(myQueue5);
		System.out.println("----------------------------------------------");
		MySequentialQueue<User> myQueue6 = new MySequentialQueue<User>(5);
		myQueue6.offer(new User("1号", 15));
		myQueue6.offer(new User("2号", 25));
		myQueue6.offer(new User("3号", 35));
		myQueue6.offer(new User("4号", 45));
		myQueue6.offer(new User("5号", 55));
		System.out.println(myQueue6);
		System.out.println("执行清空队列操作");
		myQueue6.clearQueue(myQueue6);
		System.out.println(myQueue6);
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

	public static void test03() {
		MyCircularQueue<Integer> myCircularQueue1 = new MyCircularQueue<Integer>(5);
		myCircularQueue1.enqueue(30);
		myCircularQueue1.enqueue(50);
		myCircularQueue1.enqueue(10);
		myCircularQueue1.enqueue(40);
		myCircularQueue1.enqueue(20);
		System.out.println(myCircularQueue1);

		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1);
	}
}
