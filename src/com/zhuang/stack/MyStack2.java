package com.zhuang.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @ClassName: MyStack2
 * @Description:中缀表达式转换成后缀表达式的Java代码
 * @author: KangXiaoZhuang
 * @date: 2022年11月9日 下午10:10:19
 */
public class MyStack2 implements Deque2 {
	// 定义栈的大小
	private int maxSize;

	// 数组存放栈的元素
	private char[] stackArray;

	// 栈顶的元素
	private int top;

	// 初始化栈
	@SuppressWarnings("unchecked")
	public MyStack2(int maxSize) {
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

	public char peekN(int n) {
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

class InToPost {
	private MyStack2 myStack2;
	private String input;
	private String output = "";

	public InToPost(String in) {
		input = in;
		int stackSize = input.length();
		myStack2 = new MyStack2(stackSize);
	}

	public String doTrans() {
		// A*(B+C)-D/(E+F)
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			myStack2.displayStack("For " + ch + " ");
			switch (ch) {
			case '+':
			case '-':
				getOper(ch, 1);
				break;
			case '*':
			case '/':
				getOper(ch, 2);
				break;
			case '(':
				myStack2.push(ch);
				break;
			case ')':
				getParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
		}
		while (!myStack2.isEmpty()) {
			myStack2.displayStack("While ");
			output = output + myStack2.pop();
		}
		myStack2.displayStack("End   ");
		return output;
	}

	public void getOper(char opThis, int prec1) {
		while (!myStack2.isEmpty()) {
			char opTop = myStack2.pop();
			if (opTop == '(') {
				myStack2.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-') {
					prec2 = 1;
				} else {
					prec2 = 2;
				}
				if (prec2 < prec1) {
					myStack2.push(opTop);
					break;
				} else {
					output = output + opTop;
				}
			}
		}
		myStack2.push(opThis);
	}

	public void getParen(char ch) {
		while (!myStack2.isEmpty()) {
			char chx = myStack2.pop();
			if (chx == '(') {
				break;
			} else {
				output = output + chx;
			}
		}
	}
}

class InfixApp {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans();
			System.out.println("Postfix is " + output + '\n');
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String string = br.readLine();
		return string;
	}
}
