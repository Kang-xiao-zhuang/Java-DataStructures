package com.zhuang.stack;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<Integer>(5);
		myStack.push(2);
		myStack.push(12);
		myStack.push(22);
		myStack.push(244);
		myStack.push(256);
		System.out.println(myStack.size());
		Integer pop = myStack.pop();
		System.out.println(pop);
		Integer top = myStack.peek();
		System.out.println(top);
		System.out.println(myStack);
		myStack.clearStack(myStack);
		System.out.println(myStack);
	}

}
