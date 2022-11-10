package com.zhuang.stack;

import java.util.Arrays;

/**
 * 
 * @ClassName: MyStack
 * @Description:自定义栈的方法和结构
 * @author: KangXiaoZhuang
 * @date: 2022年11月9日 下午1:10:19
 */
public class MyStack<E> implements Deque<E> {
	// 定义栈的大小
	private int maxSize;

	// 数组存放栈的元素
	private E[] stackArray;

	// 栈顶的元素
	private int top;

	// 初始化栈
	@SuppressWarnings("unchecked")
	public MyStack(int maxSize) {
		this.maxSize = maxSize;
		stackArray = (E[]) new Object[maxSize];
		top = -1;
	}

	@Override
	public void push(E e) {
		stackArray[++top] = e;
	}

	@Override
	public E pop() {
		return stackArray[top--];
	}

	@Override
	public E peek() {
		return stackArray[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == maxSize - 1;
	}

	@Override
	public String toString() {
		return Arrays.toString(stackArray);
	}
}