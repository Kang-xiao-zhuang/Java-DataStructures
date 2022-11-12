package com.zhuang.stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * @ClassName: _232_用栈实现队列
 * @Description:https://leetcode.cn/problems/implement-queue-using-stacks/
 * @author: KangXiaoZhuang
 * @date: 2022年11月12日 下午6:16:16
 */
public class _232_用栈实现队列 {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.peek());
		System.out.println(myQueue.empty());
	}
}

class MyQueue {

	private Deque<Integer> inStack;
	private Deque<Integer> outStack;

	public MyQueue() {
		inStack = new ArrayDeque<>();
		outStack = new ArrayDeque<>();
	}

	// 入队
	public void push(int x) {
		inStack.push(x);
	}

	// 弹出
	public int pop() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}

	// 队头元素
	public int peek() {
		// 当出栈为空，入栈不为空时，一直压入入栈弹出的元素
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		// 出栈的顶端元素就是队列的头
		return outStack.peek();
	}

	// 是否为空
	public boolean empty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}
}
/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */