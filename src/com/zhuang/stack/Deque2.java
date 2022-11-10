package com.zhuang.stack;

public interface Deque2 {
	// 压栈
	void push(char e);

	// 弹出元素
	char pop();

	// 返回栈顶元素
	char peek();

	// 判断是否为空
	boolean isEmpty();

	// 判断是否栈满
	boolean isFull();
}
