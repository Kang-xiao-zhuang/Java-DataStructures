# 栈

堆栈是一种==LIFO（后进先出）==的线性的数据结构，或者更抽象说是一种顺序集合，push 和pop 操作只发生在结构的一端，称为栈顶。这种结构可以很容易地从堆栈顶部取出一个项目，而要到达堆栈更深处的一个项目可能需要先取出多个其他项目。



在栈模型中，只有栈顶元素是可以访问的，具有三个主要的操作

- PUSH：将元素添加到集合

- POP：删除最近添加但尚未删除的元素

- PEEK：读取栈顶元素的值，但不移除它



# 后缀表达式

日常算术表达式是将操作符(`+，-，*，/`)放在两个操作数之间的，因此操作符写在操作数的中间，这种写法成为`中缀表达式`。



在后缀表达式中(也称为逆波兰逆序表达式)，操作符跟在两个操作数后面，这样，A+B就成为AB+，A/B成为AB/，如下图所示



![在这里插入图片描述](https://img-blog.csdnimg.cn/54c3821277bc4d95bd2d99218b79835b.png)



求解后缀表达式最容易想到的方法就是使用一个栈，当见到一个数就把它推入到栈中，在遇到一个运算符就将该运算符作用域从该栈弹出的两个数(符号)上，再将所得结果推入栈中。



例如计算下列式子

> `6 5 2 3 + 8 * + 3 + *`



前四个字符放入栈中，此时栈为



![在这里插入图片描述](https://img-blog.csdnimg.cn/2e44592149f348128f5293f5b551f6aa.png)





下面读到一个`+`号，所以3和2从栈中弹出并且计算它们的和5压入栈中



![在这里插入图片描述](https://img-blog.csdnimg.cn/d15a93766855488ca0aa9d5acef6f6f6.png)





接着，8入栈



![在这里插入图片描述](https://img-blog.csdnimg.cn/1332d260b1354aaca9fbbf680b467b11.png)



遇到一个`*`号，因此8和5弹出并且5`*`8=40 入栈



![在这里插入图片描述](https://img-blog.csdnimg.cn/90a372f60189434aa556aadf9581796d.png)



遇到一个`+`号，因此30和5被弹出并且5+40=45进栈

![在这里插入图片描述](https://img-blog.csdnimg.cn/70d8d8bf8d474d9eba0981142570ed64.png)



将3入栈

![在这里插入图片描述](https://img-blog.csdnimg.cn/f7fddc5388ea45c59c856b30c04f2024.png)

然后遇到`+`将3和45从栈中弹出并将45+3=48 入栈



![在这里插入图片描述](https://img-blog.csdnimg.cn/56eb02fad571404094d1896f1397b7b2.png)



最后遇到`*`号，从栈中弹出48和6，计算结果 288 入栈



![在这里插入图片描述](https://img-blog.csdnimg.cn/0f373a11b0a04ede9745b638e955ea56.png)



## 中缀到后缀的转换

栈不仅可以计算后缀表达式的值，还可以用栈将一个标准形式的表达式(中缀表达式)转为后缀表达式。我们通过只允许操作`+ * ( )`并坚持普通的优先级法则而将一般的问题浓缩成小规模的问题。

假设中缀表达式

> `a+b*c+(d*e+f)*g`



当读到一个操作数的时候，立即把它放到输出中。操作符不立即输出，从而必须存在某个地方。正确的做法就是将已经见到但未放到输出中的操作符推入栈中。当遇到左圆括号时，也要将其入栈。



如果遇到一个右括号，那么将元素弹出，将弹出的符号写出直至遇到一个(对应的)左括号，但是这个左括号只被弹出并不输出。



如果我们见到任何其他的符号`+ * ( )`，那么我们从栈中弹出栈元素直到发现优先级更低的元素为止。



有一个例外：除非是在处理一个`)`的时候，否则我们决不从栈中弹出`(`。对于这种操作，`+`的优先级最低，而`(`的优先级最高。当从栈弹出元素的工作完成后，我们再将操作符压入栈中。



最后，如果读到输入的末尾，我们将栈元素弹出直到该栈变成空栈，将符号写到输出中。





首先读入符号a，呗传向输出。然后，`+`被读入并放入栈中。接下来b读入并流向输出。

![在这里插入图片描述](https://img-blog.csdnimg.cn/5cd3a99451b6444a861a20d859af513f.png)



接着`*`号被读入。操作符栈的栈顶元素比`*`的优先级低，没有输出且`*`进栈。接着，c被读入并输出。

![在这里插入图片描述](https://img-blog.csdnimg.cn/fec4afdffaa546b289454065e824d31f.png)



后面的符号是一个`+`号。检查一下栈我们发现，需要将`*`从栈弹出并把它放到输出中，弹出栈中剩下的`+`号，该运算法不比刚刚遇到的`+`号优先级低而是有相同的优先级，然后，将刚刚遇到的`+`号入栈

![在这里插入图片描述](https://img-blog.csdnimg.cn/46f2f057572f47c1b426486ee325ee5e.png)



下一个被读到的符号是`(`，由于有最高的优先级，因此被它放进栈中。然后，d读入并输出

![](https://img-blog.csdnimg.cn/9d5ad93405364cc281a6069c4ff7bd54.png)



继续进行，我们读到一个`*`。由于除非正在处理闭括号否则开括号不会从栈中弹出，因此没有输出。下一个是e，它被读入并输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/0225ed0cdce443aaa602ab53f642c22f.png)



再往后读到的符号是`+`。我们将`*`弹出并输出，然后将+压入栈中。这以后，我们读到f并输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/767c2101fc284ac19145276d8987ba98.png)



现在，我们读到一个`)`，因此将栈元素直到`(`弹出，我们将一个`+`号输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/7b30395ddb194319bf51a62fe3951286.png)



下面又读到一个`*`，将该运算符压入栈中。然后g被读入并输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/2c99b25eda30417dae0b8f690dc1ba8a.png)



现在输入为空，因此我们将栈中的符号全部弹出并输出，直到栈为空

![在这里插入图片描述](https://img-blog.csdnimg.cn/0405ae48a8004f5fbef424ea5753331b.png)



## 解析算术表达式

![在这里插入图片描述](https://img-blog.csdnimg.cn/16efa15004514a0eb720caea4cde775b.png)



![在这里插入图片描述](https://img-blog.csdnimg.cn/e58cc52316a94725a1b100222f1faec8.png)







![在这里插入图片描述](https://img-blog.csdnimg.cn/79d5c9d2cd2c44cd8a70baeb65e0fce7.png)





![在这里插入图片描述](https://img-blog.csdnimg.cn/8bdc9a1333914d2da73d61359c4b0481.png)



![在这里插入图片描述](https://img-blog.csdnimg.cn/e6507982115c4949b83dbf088c4c1c5a.png)



![在这里插入图片描述](https://img-blog.csdnimg.cn/36c47640649b477dab9f00b6906ce589.png)



![在这里插入图片描述](https://img-blog.csdnimg.cn/d1f32ba573234496a3b72948aa3b898c.png)





![image-20221109212703766](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20221109212703766.png)

































# 实现堆栈结构

我们平常使用不会直接使用Java 提供的Stack的，使用`ArrayDeque`替代，Deque 接口及其实现提供了一组更完整和一致的LIFO 堆栈操作，应优先使用此类。



![在这里插入图片描述](https://img-blog.csdnimg.cn/f9961892f3394521a62bcf58b0ecdd04.png)



**Deque接口**

```java
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
```

**MyStack实现类**

```java
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
```

**测试类**

```java
public class MyStackTest {

	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<Integer>(5);
		myStack.push(2);
		myStack.push(12);
		myStack.push(22);
		myStack.push(244);
		myStack.push(256);
		Integer pop = myStack.pop();
		System.out.println(pop);
		Integer top = myStack.peek();
		System.out.println(top);
		System.out.println(myStack);
	}

}
```



```java
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
```

