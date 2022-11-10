package com.zhuang.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @ClassName: MyStackExample02
 * @Description:校验括号的合法性
 * @author: KangXiaoZhuang
 * @date: 2022年11月9日 下午10:10:19
 */
public class MyStackExample02 implements Deque2 {
	// 定义栈的大小
	private int maxSize;

	// 数组存放栈的元素
	private char[] stackArray;

	// 栈顶的元素
	private int top;

	// 初始化栈
	@SuppressWarnings("unchecked")
	public MyStackExample02(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char e) {
		stackArray[++top] = e;
	}

	@Override
	public char pop() {
		return stackArray[top--];
	}

	@Override
	public char peek() {
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

	public int size() {
		return top + 1;
	}
}

class BracketChecker {
	private String input;

	public BracketChecker(String s) {
		input = s;
	}

	public void check() {
		int stackSize = input.length();
		MyStackExample02 theStack = new MyStackExample02(stackSize);
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!theStack.isEmpty()) {
					char tempch = theStack.pop();
					if (ch == '{' && tempch != '}' || ch == ']' && tempch != '[' || ch == ')' && tempch != '(') {
						System.out.println("Error: " + ch + " at " + j);
					}
				} else {
					System.out.println("Error: " + ch + " at " + j);
				}
				break;
			default:
				break;
			}
		}
	}

}

class BracketsApp {
	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.print("Enter String containing delimiters: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			BracketChecker bracketChecker = new BracketChecker(input);
			bracketChecker.check();
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String string = br.readLine();
		return string;
	}
}