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

	// 返回栈的大小
	int size();

	// 清空栈元素
	MyStack<E> clearStack(MyStack<E> myStack);

	// 销毁栈
	boolean destoryStack(MyStack<E> myStack);
}
