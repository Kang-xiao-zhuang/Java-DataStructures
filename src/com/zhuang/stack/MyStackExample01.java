package com.zhuang.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @ClassName: MyStackExample01
 * @Description:单词逆序代码
 * @author: KangXiaoZhuang
 * @date: 2022年11月9日 下午10:10:19
 */
public class MyStackExample01 implements Deque2 {
	// 定义栈的大小
	private int maxSize;

	// 数组存放栈的元素
	private char[] stackArray;

	// 栈顶的元素
	private int top;

	// 初始化栈
	@SuppressWarnings("unchecked")
	public MyStackExample01(int maxSize) {
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

class Reverser {
	private String input;
	private String output;

	public Reverser(String s) {
		input = s;
	}

	public String doRev() {
		int stackSize = input.length();
		MyStackExample01 theStack = new MyStackExample01(stackSize);
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			theStack.push(ch);
		}
		output = "";
		while (!theStack.isEmpty()) {
			char ch = theStack.pop();
			output += ch;

		}
		return output;
	}

}

class ReverserApp {
	public static void main(String[] args) throws IOException {
		String input;
		String output;
		while (true) {
			System.out.print("Enter a String: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			Reverser reverser = new Reverser(input);
			output = reverser.doRev();
			System.out.println("Reversed: " + output);
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String string = br.readLine();
		return string;
	}
}