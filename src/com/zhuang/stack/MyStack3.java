package com.zhuang.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @ClassName: MyStack3
 * @Description:后缀表达式求值Java代码
 * @author: KangXiaoZhuang
 * @date: 2022年11月9日 下午10:10:19
 */
public class MyStack3 implements Deque3 {
	// 定义栈的大小
	private int maxSize;

	// 数组存放栈的元素
	private int[] stackArray;

	// 栈顶的元素
	private int top;

	// 初始化栈
	@SuppressWarnings("unchecked")
	public MyStack3(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int e) {
		stackArray[++top] = e;
	}

	@Override
	public int pop() {
		return stackArray[top--];
	}

	@Override
	public int peek() {
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

	public int peekN(int n) {
		return stackArray[n];
	}

	public void displayStack(String s) {
		System.out.print(s);
		System.out.print("Stack (bottom-->top): ");
		for (int i = 0; i < size(); i++) {
			System.out.print(peekN(i));
			System.out.print(' ');
		}
		System.out.println("");
	}
}

class ParsePost {
	private MyStack3 myStack3;
	private String input;

	public ParsePost(String s) {
		input = s;
	}

	public int doParse() {
		myStack3 = new MyStack3(20);
		char ch;
		int j;
		int num1, num2, interAns;
		for (j = 0; j < input.length(); j++) {
			ch = input.charAt(j);
			myStack3.displayStack("" + ch + " ");
			if (ch >= '0' && ch <= '9') {
				// 数字就入栈
				myStack3.push((int) (ch - '0'));
			} else {
				// 运算符就计算弹出栈的两个值
				num2 = myStack3.pop();
				num1 = myStack3.pop();
				switch (ch) {
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				case '/':
					interAns = num1 / num2;
					break;
				default:
					interAns = 0;
					break;
				}
				myStack3.push(interAns);
			}
		}
		interAns = myStack3.pop();
		return interAns;
	}

}

class PostfixApp {
	public static void main(String[] args) throws IOException {
		// 345+*612+/-
		String input;
		int output;
		while (true) {
			System.out.print("Enter postfix: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				System.out.println("程序结束!");
				break;
			}
			ParsePost aParser = new ParsePost(input);
			output = aParser.doParse();
			System.out.println("Evaluates to " + output);
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String string = br.readLine();
		return string;
	}
}