package com.zhuang.stack;

public interface Deque3 {
	// 压栈
	void push(int e);

	// 弹出元素
	int pop();

	// 返回栈顶元素
	int peek();

	// 判断是否为空
	boolean isEmpty();

	// 判断是否栈满
	boolean isFull();
}
