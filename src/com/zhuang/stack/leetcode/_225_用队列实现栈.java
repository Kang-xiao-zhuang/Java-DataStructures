package com.zhuang.stack.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @ClassName: _225_用队列实现栈
 * @Description:https://leetcode.cn/problems/implement-stack-using-queues/
 * @author: KangXiaoZhuang
 * @date: 2022年11月12日 下午6:16:33
 */
public class _225_用队列实现栈 {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack.pop());
		System.out.println(myStack.top());
		System.out.println(myStack.empty());
	}
}

class MyStack {

	Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<Integer>();
	}

	public void push(int x) {
		int n = queue.size();
		queue.offer(x);
		for (int i = 0; i < n; i++) {
			queue.offer(queue.poll());
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */