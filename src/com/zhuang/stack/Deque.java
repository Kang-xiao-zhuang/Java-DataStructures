package com.zhuang.stack;

public interface Deque<E> {
	// 压栈
	void push(E e);

	// 弹出元素
	E pop();

	// 返回栈顶元素
	E peek();

	// 判断是否为空
	boolean isEmpty();

	// 判断是否栈满
	boolean isFull();
}
