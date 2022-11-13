# 队列

## 队列的定义

队列（queue）是只允许在一端进行插入操作，而在另一端进行删除操作的线性表。



队列是一种先进先出（First In First Out）的线性表，简称FIFO。允许插入的一端称为队尾，允许删除的一端称为队头。假设队列是q=(a ~1~,a~2~,......,a~n~)，那么a~1~就是队头元素，而a ~n~是队尾元素。这样我们就可以删除时，总是从a~1~开始，而插入时，列在最后。这也比较符合我们通常生活中的习惯，排在第一个的优先出列，最后来的当然排在队伍最后。



![在这里插入图片描述](https://img-blog.csdnimg.cn/ed4ecd979a684c8bb23fb9af275f311a.png)



- 从理论上讲，队列的一个特征是它没有特定的容量。不管已经包含多少元素，总是可以再添加一个新元素。
- 队列既可以是数组实现也可以是链表实现。所以当我们在Java 中使用队列的时候，Deque 的实现类就是；LinkedList 和ArrayDeque 的实现类。
- 队列不只是单端从一个口入另外一个口出，也可以是双端队列。例如在Java 中Queue 是单端队列接口、Deque 是双端队列接口，都有对应的实现类

## 顺序队列实现

**SequentialQueue**

```java
public interface SequentialQueue<E> {
	// 入队
	void offer(E data);

	// 出队
	E poll();

	// 队头
	E peekFont();

	// 判断是否队空
	boolean isEmpty();

	// 判断是否队满
	boolean isFull();

	// 队大小
	int size();

	// 销毁队列
	boolean destoryQueue(MySequentialQueue<E> myQueue);

	// 清空队列
	MySequentialQueue<E> clearQueue(MySequentialQueue<E> myQueue);
}
```

**MySequentialQueue**

```java
/**
 * 
 * @ClassName: MyQueue
 * @Description:自定义队列
 * @author: KangXiaoZhuang
 * @date: 2022年11月13日 上午11:19:33
 */
public class MySequentialQueue<E> implements SequentialQueue<E> {
	// 队列大小
	private int size;
	// 数组实现
	private E[] queueArray;
	// 队头
	private int front;
	// 队尾
	private int rear;
	// 队内元素
	private int item;

	// 初始化队列
	@SuppressWarnings("unchecked")
	public MySequentialQueue(int s) {
		size = s;
		queueArray = (E[]) new Object[size];
		front = 0;
		rear = -1;
		item = 0;
	}

	@Override
	public void offer(E e) {
		if (rear == size - 1) {
			rear = -1;
		}
		queueArray[++rear] = e;
		item++;
	}

	@Override
	public E poll() {
		E temp = queueArray[front++];
		if (front == size) {
			front = 0;
		}
		item--;
		return temp;
	}

	@Override
	public E peekFont() {
		return queueArray[front];
	}

	@Override
	public boolean isEmpty() {
		return item == 0;
	}

	@Override
	public boolean isFull() {
		if (item == 0 && size == 0) {
			return false;
		}
		return item == size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean destoryQueue(MySequentialQueue<E> myQueue) {
		myQueue.size = 0;
		myQueue.queueArray = null;
		myQueue.front = 0;
		myQueue.rear = -1;
		myQueue.item = 0;
		return true;
	}

	@Override
	public MySequentialQueue<E> clearQueue(MySequentialQueue<E> myQueue) {
		for (int i = 0; i < myQueue.queueArray.length; i++) {
			myQueue.queueArray[i] = null;
		}
		return myQueue;
	}

	public void display(MySequentialQueue<E> queue) {
		while (!queue.isEmpty()) {
			E e = queue.poll();
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		// 获取队列有效元素
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = front; i <= rear; i++) {
			sb.append(" " + queueArray[i] + " ");
		}
		sb.append("]");
		// 返回队列详细信息
		return "MySequentialQueue{" + "front=" + front + ", rear=" + rear + ", elements=" + sb.toString() + ", eleSize="
				+ size() + ", size=" + size + ", isEmpty=" + isEmpty() + ", isFull=" + isFull() + '}';
	}
}
```

**测试类**

```java
public static void test01() {
		MySequentialQueue<Integer> myQueue1 = new MySequentialQueue<Integer>(5);
		myQueue1.offer(10);
		myQueue1.offer(20);
		myQueue1.offer(30);
		myQueue1.offer(40);
		System.out.println("队头:" + myQueue1.peekFont());
		System.out.println(myQueue1);
		System.out.println("----------------------------------------------");
		MySequentialQueue<Integer> myQueue2 = new MySequentialQueue<Integer>(5);
		myQueue2.offer(10);
		myQueue2.offer(20);
		myQueue2.offer(30);
		myQueue2.offer(40);
		myQueue2.poll();
		myQueue2.poll();
		myQueue2.poll();
		System.out.println("队头:" + myQueue2.peekFont());
		System.out.println(myQueue2);
		System.out.println("----------------------------------------------");
		MySequentialQueue<Integer> myQueue3 = new MySequentialQueue<Integer>(5);
		myQueue3.offer(10);
		myQueue3.offer(20);
		myQueue3.offer(30);
		myQueue3.offer(40);
		myQueue3.poll();
		myQueue3.poll();
		myQueue3.poll();
		myQueue3.poll();
		System.out.println("队头:" + myQueue3.peekFont());
		System.out.println(myQueue3);
		System.out.println("----------------------------------------------");
		MySequentialQueue<String> myQueue4 = new MySequentialQueue<String>(5);
		myQueue4.offer("A");
		myQueue4.offer("B");
		myQueue4.offer("C");
		myQueue4.offer("D");
		myQueue4.offer("E");
		System.out.println("队头:" + myQueue4.peekFont());
		System.out.println(myQueue4);
		System.out.println("----------------------------------------------");
		MySequentialQueue<String> myQueue5 = new MySequentialQueue<String>(5);
		myQueue5.offer("A");
		myQueue5.offer("B");
		myQueue5.offer("C");
		myQueue5.offer("D");
		myQueue5.offer("E");
		System.out.println(myQueue5);
		System.out.println("执行销毁队列操作");
		myQueue5.destoryQueue(myQueue5);
		System.out.println(myQueue5);
		System.out.println("----------------------------------------------");
		MySequentialQueue<User> myQueue6 = new MySequentialQueue<User>(5);
		myQueue6.offer(new User("1号", 15));
		myQueue6.offer(new User("2号", 25));
		myQueue6.offer(new User("3号", 35));
		myQueue6.offer(new User("4号", 45));
		myQueue6.offer(new User("5号", 55));
		System.out.println(myQueue6);
		System.out.println("执行清空队列操作");
		myQueue6.clearQueue(myQueue6);
		System.out.println(myQueue6);
	}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/9cf8fd5341d041d89a17c31acc9170c3.png)

## 循环队列

循环队列就是将队列存储空间的最后一个位置绕到第一个位置，形成逻辑上的环状空间，供队列循环使用。在循环队列结构中，当存储空间的最后一个位置已被使用而再要进入队运算时，只需要存储空间的第一个位置空闲，便可将元素加入到第一个位置，即将存储空间的第一个位置作为队尾。 循环队列可以更简单防止“假溢出”的发生，但队列大小是固定的。



在循环队列中，当队列为空时，有`front=rear`，而当所有队列空间全占满时，也有`front=rear`。为了区别这两种情况，规定循环队列最多只能有MaxSize-1个队列元素，当循环队列中只剩下一个空存储单元时，队列就已经满了。因此，队列判空的条件是`front == rear`，而队列判满的条件是`((rear + 1) % maxSize) == front`。



![在这里插入图片描述](https://img-blog.csdnimg.cn/91c411a99de64fefb3caa62dfbb22502.png)

## 循环队列实现

**CircularQueue**

```java
public interface CircularQueue<E> {

	boolean isEmpty();

	boolean isFull();

	int size();

	void enqueue(E element);

	E dequeue();

}
```

**MyCircularQueue**

```java
public class MyCircularQueue<E> implements CircularQueue<E> {
	// 指向队头元素，默认为0
	private int front;
	// 指向队尾元素，默认为0
	private int rear;
	// 存放队列元素，默认为null
	private E[] circularQueueArray;
	// 队列最大容量，默认为0
	private int size;

	public MyCircularQueue(int capacity) {
		// 有一个没用的元素，所以这里加一
		size = capacity + 1;
		// 有一个没用的元素，所以这里加一
		circularQueueArray = (E[]) new Object[capacity + 1];
	}

	@Override
	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	// 判断队列是否已满
	public boolean isFull() {
		return ((rear + 1) % size) == front;
	}

	@Override
	// 获取队列元素个数
	public int size() {
		return (rear - front + size) % size;
	}

	@Override
	// 入队列
	public void enqueue(E element) {
		// 判断队列是否已满
		if (isFull()) {
			System.out.println("队列已满，插入失败：" + element);
			return;
		}
		// 入队列
		circularQueueArray[rear] = element;
		// 向后移
		rear = (rear + 1) % size;
	}

	@Override
	// 出队列
	public E dequeue() {
		// 判断队列是否为空
		if (isEmpty()) {
			System.out.println("队列已空，获取失败");
			return null;
		}
		// 出队列
		E element = circularQueueArray[front];
		// 向后移
		front = (front + 1) % size;
		return element;
	}

	@Override
	public String toString() {
		// 获取队列有效元素
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = front; i < front + size(); i++) {
			sb.append(" " + circularQueueArray[i % size] + " ");
		}
		sb.append("]");
		// 返回队列详细信息
		return "circularQueueArray{" + "front=" + front + ", rear=" + rear + ", elements=" + sb.toString()
				+ ", eleSize=" + size() + ", size=" + (size - 1) + // 有一个没用的元素，所以这里减一
				", isEmpty=" + isEmpty() + ", isFull=" + isFull() + '}';
	}
}
```

**测试类**

```java
	public static void test03() {
		MyCircularQueue<Integer> myCircularQueue1 = new MyCircularQueue<Integer>(5);
		myCircularQueue1.enqueue(30);
		myCircularQueue1.enqueue(50);
		myCircularQueue1.enqueue(10);
		myCircularQueue1.enqueue(40);
		myCircularQueue1.enqueue(20);
		System.out.println(myCircularQueue1);

		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1);
	}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/b5499effabc84cb1bc4efefd90aaa540.png)



## 优先级队列 

优先级队列是比栈和队列更专用的数据结构 ，像普通队列一样，优先级队列有一个队头和一个队尾，并且也是从队头移除数据项，不过在优先级队列中，数据项按关键字的值有序，这样关键字最小的数据项(或者某些实现中是关键字最大的数据项)总是在队头。



数据项插入的时候会按照顺序插入到何时的位置以确保队列的顺序



**优先级队列插入数据的图示**

![在这里插入图片描述](https://img-blog.csdnimg.cn/36166e3db3ad4264a82ec639849d1194.png)



## 优先级队列实现

```java
public class MyPriorityQueue {
	private int size;
	private long[] queueArray;
	private int item;

	public MyPriorityQueue(int s) {
		size = s;
		queueArray = new long[size];
		item = 0;
	}

	public void offer(long data) {
		int j;
		if (item == 0) {
			queueArray[item++] = data;
		} else { // item>0
			for (j = item - 1; j >= 0; j--) {
				// 数组排序
				if (data > queueArray[j]) {
					queueArray[j + 1] = queueArray[j];
				} else {
					break;
				}
			}
			queueArray[j + 1] = data;
			item++;
		}
	}

	public long poll() {
		return queueArray[--item];
	}

	public long peekMin() {
		return queueArray[item - 1];
	}

	public boolean isEmpty() {
		return item == 0;
	}

	public boolean isFull() {
		return item == size;
	}

	public void display(MyPriorityQueue myPriorityQueue) {
		while (!myPriorityQueue.isEmpty()) {
			long e = myPriorityQueue.poll();
			System.out.print(e + " ");
		}
		System.out.println("");
	}
}
```

**测试类**

```java
public static void test03() {
		MyCircularQueue<Integer> myCircularQueue1 = new MyCircularQueue<Integer>(5);
		myCircularQueue1.enqueue(30);
		myCircularQueue1.enqueue(50);
		myCircularQueue1.enqueue(10);
		myCircularQueue1.enqueue(40);
		myCircularQueue1.enqueue(20);
		System.out.println(myCircularQueue1);

		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1.dequeue());
		System.out.println(myCircularQueue1);
	}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/80f6a06c69c248e28c0c78d1caa07e8b.png)

## 常见面试题

[队列面试题](https://blog.csdn.net/zlfing/article/details/110039830)

## 队列相关题目

[387. 字符串中的第一个唯一字符 - 力扣（LeetCode）](https://leetcode.cn/problems/first-unique-character-in-a-string/)

```java
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> position = new HashMap<Character, Integer>();
		Queue<Pair> queue = new LinkedList<Pair>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (!position.containsKey(ch)) {
				position.put(ch, i);
				queue.offer(new Pair(ch, i));
			} else {
				position.put(ch, -1);
				while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
					queue.poll();
				}
			}
		}
		return queue.isEmpty() ? -1 : queue.poll().pos;
    }
}
class Pair {
	char ch;
	int pos;

	public Pair(char ch, int pos) {
		super();
		this.ch = ch;
		this.pos = pos;
	}
}
```

[933. 最近的请求次数 - 力扣（LeetCode）](https://leetcode.cn/problems/number-of-recent-calls/)

```java
class RecentCounter {
    LinkedList<Integer> list=new LinkedList<Integer>();
    public RecentCounter() {

    }
    
    public int ping(int t) {
        list.add(t);
        while(list.get(0)<t-3000){
            list.remove(0);
        }
        return list.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
```

[1700. 无法吃午餐的学生数量 - 力扣（LeetCode）](https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/)

```java
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentQueue = new LinkedList<>();
        Deque<Integer> sandwichesStack = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentQueue.offer(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            sandwichesStack.offer(sandwiches[i]);
        }
        //用来记录有多少的学生不喜欢当前的sandwich 如果匹配上了就重置为0 ，如果一直没匹配上就+1，如果这个大小等于sandwich栈的长度就当做下面结束循环的条件之一
        int disLikeNum = 0;

        while (!studentQueue.isEmpty() && !sandwichesStack.isEmpty()) {
            if (disLikeNum == sandwichesStack.size()) {
                break;
            }
            Integer student = studentQueue.poll();
            //当前栈顶的sandwich
            Integer sandwiche = sandwichesStack.peek();
            if (student == sandwiche) {
                sandwichesStack.pop();
                disLikeNum = 0;
            } else {
                disLikeNum++;
                studentQueue.offer(student);
            }           
        }
        return studentQueue.isEmpty() ? 0 : sandwichesStack.size();

    }
}
```

[2073. 买票需要的时间 - 力扣（LeetCode）](https://leetcode.cn/problems/time-needed-to-buy-tickets/)

```java
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
		int index = 0;
		int second = 0;
		if (tickets.length == 1) {
			return tickets[0];
		}
		// 模拟购票
		while (tickets[k] != 0) {
			// 去除已经完成购票的人
			if (tickets[index] > 0) {
				tickets[index]--;
				// 时间增加
				second++;
			}
			index++;
			if (index == tickets.length) {
				// 开始下一轮购票
				index = 0;
			}
		}
		return second;
	}
}
```

