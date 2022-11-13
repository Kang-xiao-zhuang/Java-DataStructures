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
		// 判断栈是否满
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException("栈满！不能添加元素");
		}
		stackArray[++top] = e;
	}

	@Override
	public E pop() {
		if (top==-1) {
			throw new NullPointerException("栈空！不能弹出元素");
		}
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
	public int size() {
		return maxSize;
	}

	@Override
	public MyStack<E> clearStack(MyStack<E> myStack) {
		for (int i = 0; i < myStack.stackArray.length; i++) {
			myStack.stackArray[i] = null;
		}
		return myStack;
	}

	@Override
	public boolean destoryStack(MyStack<E> myStack) {
		myStack.maxSize = 0;
		myStack.stackArray = null;
		return true;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(stackArray);
	}
}