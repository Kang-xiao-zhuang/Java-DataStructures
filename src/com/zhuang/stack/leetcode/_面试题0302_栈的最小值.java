package com.zhuang.stack.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @ClassName: _面试题0302_栈的最小值
 * @Description:https://leetcode.cn/problems/min-stack-lcci/
 * @author: KangXiaoZhuang
 * @date: 2022年11月12日 下午7:33:04
 */
public class _面试题0302_栈的最小值 {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // --> 返回 -3.
		minStack.pop();
		System.out.println(minStack.top()); // --> 返回 0.
		System.out.println(minStack.getMin()); // --> 返回 -2.
	}

}

class MinStack {
	Deque<Integer> xStack;
	Deque<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		xStack = new LinkedList<>();
		minStack = new LinkedList<>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		xStack.push(x);
		minStack.push(Math.min(minStack.peek(), x));
	}

	public void pop() {
		xStack.pop();
		minStack.pop();
	}

	public int top() {
		return xStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */