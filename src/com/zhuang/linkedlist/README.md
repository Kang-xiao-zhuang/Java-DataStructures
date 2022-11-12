# 链表

链表是一种通过指针串联在一起的线性结构，每一个节点由两部分组成，一个是数据域一个是指针域（存放指向下一个节点的指针），最后一个节点的指针域指向null（空指针的意思）。



链接的入口节点称为链表的头结点也就是head



链表的数据结构通过链的连接方式，提供了可以不需要扩容空间就更高效的插入和删除元素的操作，在适合的场景下它是一种非常方便的数据结构。但在一些需
要遍历、指定位置操作、或者访问任意元素下，是需要循环遍历的，这将导致时间复杂度的提升



## 链表的分类

### 1. 单向链表

单链表包含具有数据字段的节点以及指向节点行中的下一个节点的“下一个”字段。可以对单链表执行的操作包括插入、删除和遍历

![在这里插入图片描述](https://img-blog.csdnimg.cn/43b0e7f1a4834fb3aef79f613c510913.png)

### 2. 双向链表

在“双向链表”中，除了下一个节点链接之外，每个节点还包含指向序列中“前一个”节点的第二个链接字段。这两个链接可以称为'forward（'s'）和'backwards'，
或'next'和'prev'（'previous'）

![在这里插入图片描述](https://img-blog.csdnimg.cn/cbcc8ac2c8254b4ab8df7b4105a8f7e5.png)

### 3. 循环链表

在列表的最后一个节点中，链接字段通常包含一个空引用，一个特殊的值用于指示缺少进一步的节点。一个不太常见的约定是让它指向列表的第一个节点。在这
种情况下，列表被称为“循环”或“循环链接”；否则，它被称为“开放”或“线性”。它是一个列表，其中最后一个指针指向第一个节点



![在这里插入图片描述](https://img-blog.csdnimg.cn/b7620d7fd7aa4914b35c9da76aa4d37d.png)

****

![在这里插入图片描述](https://img-blog.csdnimg.cn/39938e13143e4578a61ad271f9b8f44a.png)

## LinkedList类的实现重要方法

**List接口**

```java
public interface List<E> {
	boolean add(E e);

	boolean addFirst(E e);

	boolean addLast(E e);

	boolean remove(Object o);

	E get(int index);

	void printLinkList();
}
```

### 头插节点

头插的操作流程

- 先把头节点记录下来`temp`，之后创建一个新的节点。新的节点构造函数的头节点入参为`null`，构建出一个新的节点

- 原来的头节点，设置`first.prev`连接到新的头节点，完成头插的操作
- 如果原来就没有头节点，头节点设置新的节点即可。
- 最后记录当前链表中节点的数量

![在这里插入图片描述](https://img-blog.csdnimg.cn/1aad84fd8d5a413d9a910ad1681689d5.png)

```java
/**
	 * 
	 * @Title: linkFirst
	 * @Description: 头插节点
	 * @param: @param e
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void linkFirst(E e) {
		// 定义temp节点
		final Node<E> temp = first;
		// 定义新的节点 没有前驱，后继就是first
		final Node<E> newNode = new Node<>(null, e, temp);
		// 新的节点直接成为first
		first = newNode;
		if (temp == null) {
			last = newNode;
		} else {
			temp.prev = newNode;
		}
		size++;
	}
```

### 尾插节点

- 记录当前的尾节点`tempLast`，创建新的节点，并把当前的尾节点，通过`tempLast.next = newNode`关联到新创建的节点上。
- 记录``size`节点数量值

![在这里插入图片描述](https://img-blog.csdnimg.cn/fbed93e273864388b6ff4f77e7e9b034.png)



```java
/**
	 * 
	 * @Title: linkLast
	 * @Description: 尾插节点
	 * @param: @param e
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void linkLast(E e) {
		final Node<E> tempLast = last;
		// 只有前驱，没有后继
		final Node<E> newNode = new Node<>(tempLast, e, null);
		// 最后的节点就是新的节点
		last = newNode;
		if (tempLast == null) {
			first = newNode;
		} else {
			tempLast.next = newNode;
		}
		size++;
	}
```

### 拆链操作



![在这里插入图片描述](https://img-blog.csdnimg.cn/873e778bbf3a4a49980ed035fc671b41.png)



```java
/**
	 * 
	 * @Title: unlink
	 * @Description: 拆链操作
	 * @param: @param  node
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E unlink(Node<E> node) {
		E element = node.data;
		// 后继
		Node<E> next = node.next;
		// 前驱
		Node<E> prev = node.prev;
		// 没有前驱节点,代表node节点在头部
		if (prev == null) {
			// next直接成为first
			first = next;
		} else {
			// 1 2 3 4
			// 将node节点的后继前移
			prev.next = next;
			// node节点的前驱置为空
			node.prev = null;
		}
		// 没有后继节点,代表node节点在尾部
		if (next == null) {
			// node的前驱直接是最后
			last = prev;
		} else {
			// 1 2 3 4
			// 将node节点的前驱后移
			next.prev = prev;
			// node节点的后继置为空
			node.next = null;
		}
		// 值置为空
		node.data = null;
		// 长度自减
		size--;
		return element;
	}
```

### 删除节点

- 删除元素需要循环比较元素的值，进行删除
- 比对的过程的复杂度O(n)
- 删除的过程复杂度O(1)

```java
public boolean remove(Object o) {
		if (o == null) {
			// 遍历
			Node<E> node = first;
			while (node != null) {
				if (node.data == null) {
					unlink(node);
					return true;
				}
				node = node.next;
			}
		} else {
			// 遍历
			Node<E> node = first;
			while (node != null) {
				if (o.equals(node.data)) {
					unlink(node);
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
```

**LinkedList完整代码**

```java
@SuppressWarnings("all")
/**
 * 
 * @ClassName: LinkedList
 * @Description:LinkedList代码
 * @author: KangXiaoZhuang
 * @date: 2022年11月10日 下午8:41:20
 */
public class LinkedList<E> implements List<E> {

	transient int size = 0;

	transient Node<E> first;

	transient Node<E> last;

	public LinkedList() {

	}

	/**
	 * 
	 * @Title: linkFirst
	 * @Description: 头插节点
	 * @param: @param e
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void linkFirst(E e) {
		// 定义temp节点
		final Node<E> temp = first;
		// 定义新的节点 没有前驱，后继就是first
		final Node<E> newNode = new Node<>(null, e, temp);
		// 新的节点直接成为first
		first = newNode;
		if (temp == null) {
			last = newNode;
		} else {
			temp.prev = newNode;
		}
		size++;
	}

	/**
	 * 
	 * @Title: linkLast
	 * @Description: 尾插节点
	 * @param: @param e
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void linkLast(E e) {
		final Node<E> tempLast = last;
		// 只有前驱，没有后继
		final Node<E> newNode = new Node<>(tempLast, e, null);
		// 最后的节点就是新的节点
		last = newNode;
		if (tempLast == null) {
			first = newNode;
		} else {
			tempLast.next = newNode;
		}
		size++;
	}

	/**
	 * 
	 * @Title: unlink
	 * @Description: 拆链操作
	 * @param: @param  node
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E unlink(Node<E> node) {
		E element = node.data;
		// 后继
		Node<E> next = node.next;
		// 前驱
		Node<E> prev = node.prev;
		// 没有前驱节点,代表node节点在头部
		if (prev == null) {
			// next直接成为first
			first = next;
		} else {
			// 1 2 3 4
			// 将node节点的后继前移
			prev.next = next;
			// node节点的前驱置为空
			node.prev = null;
		}
		// 没有后继节点,代表node节点在尾部
		if (next == null) {
			// node的前驱直接是最后
			last = prev;
		} else {
			// 1 2 3 4
			// 将node节点的前驱后移
			next.prev = prev;
			// node节点的后继置为空
			node.next = null;
		}
		// 值置为空
		node.data = null;
		// 长度自减
		size--;
		return element;
	}

	@Override
	public boolean add(E e) {
		linkLast(e);
		return true;
	}

	@Override
	public boolean addFirst(E e) {
		linkFirst(e);
		return true;
	}

	@Override
	public boolean addLast(E e) {
		linkLast(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			// 遍历
			Node<E> node = first;
			while (node != null) {
				if (node.data == null) {
					unlink(node);
					return true;
				}
				node = node.next;
			}
		} else {
			// 遍历
			Node<E> node = first;
			while (node != null) {
				if (o.equals(node.data)) {
					unlink(node);
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		return node(index).data;
	}

	@Override
	public void printLinkList() {
		if (this.size == 0) {
			System.out.println("链表为空");
		} else {
			Node<E> temp = first;
			System.out.print("目前的列表，头节点：" + first.data + " 尾节点：" + last.data + " \n整体：");
			while (temp != null) {
				System.out.print(temp.data + "，");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @Title: node
	 * @Description: 找到指定索引的节点
	 * @param: @param  index
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public Node<E> node(int index) {
		/*
		 * Node<E> node = first; for (int i = 0; i < index; i++) { node = node.next; }
		 */
		// 可以使用折半优化下
		if (index < (size >> 1)) {
			// 从头找
			Node node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			// 从尾找
			Node node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.next;
			}
			return node;
		}
	}

	private static class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		public Node(Node<E> prev, E element, Node<E> next) {
			this.data = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
```

**测试**

```java
public class LinkedListTest {
	public static void main(String[] args) {
		test01();
	}

	public static void test01() {
		List<String> list = new LinkedList<>();
		// 添加元素
		list.add("a");
		list.addFirst("b");
		list.addLast("c");
		list.printLinkList();
		// 头插元素
		list.addFirst("d");
		// 删除元素
		list.remove("b");
		// 打印列表
		list.printLinkList();
	}
}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/642cb016ee32434cbe6469bb2d2a77cc.png)

## 另一种实现方法

**MyList接口**

```java
public interface MyList<E> {
	void clear();

	int size();

	boolean isEmpty();

	E get(int index);

	E set(int index, E newElement);

	boolean add(E addElement);

	void add(int index, E addElement);

	E remove(int index);
}
```

考虑设计方面，提供几个类

1. LinkedList类本身，包含两端的链，表的大小以及一些方法
2. Node类，私有的嵌套类，一个节点包含数据以及前一个节点的链和到下一个节点的类，适当的构造方法

## 查找的优化

这里查找元素可以使用二分，距离头近就从头开始找，距离尾近就从尾开始找，缩小搜索的时间

```java
/**
	 * 
	 * @Title: getNode
	 * @Description: 根据索引获取节点(二分查找，速度更快)
	 * @param: @param  index 索引
	 * @param: @return Node
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	private Node<E> getNode(int index) {
		Node<E> node = null;
		rangeCheck(index);
		// 折半查找
		// 距离头近
		if (index < size() >> 1) {
			node = beginMarker.next;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			// 距离尾近
		} else {
			node = endMarker;
			for (int i = size(); i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}
```

**MyLinkedList完整代码**

```java
/**
 * 
 * @ClassName: MyLinkedList
 * @Description:TODO 另一种方法实现链表
 * @author: KangXiaoZhuang
 * @date: 2022年11月10日 下午9:29:35
 */
public class MyLinkedList<E> implements MyList<E> {

	// 找不到值为-1
	public static final int ELEMENT_NOT_FOUND = -1;
	// 链表大小
	private int size;

	// 头节点
	private Node<E> beginMarker;

	// 尾节点
	private Node<E> endMarker;

	// 构造方法
	public MyLinkedList() {
		clear();
	}

	@Override
	public void clear() {
		// 初始化头节点为空
		beginMarker = new Node<>(null, null, null);
		// 初始化尾节点
		endMarker = new Node<>(null, beginMarker, null);
		// 尾节点前面就是头节点
		// 下面两句同样效果
		beginMarker.next = endMarker;
		// endMarker.prev = beginMarker;
		// 大小
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public E get(int index) {
		return getNode(index).data;
	}

	@Override
	public E set(int index, E newData) {
		// 获取指定索引的节点
		Node<E> node = getNode(index);
		// 获取旧值
		E old = node.data;
		// 新值覆盖
		node.data = newData;
		return old;
	}

	@Override
	public boolean add(E addElement) {
		// 直接在尾部插入
		add(size(), addElement);
		return true;
	}

	@Override
	public void add(int index, E addElement) {
		addBefore(getNode(index), addElement);
	}

	@Override
	public E remove(int index) {
		return remove(getNode(index));
	}

	/**
	 * 
	 * @Title: getNode
	 * @Description: 根据索引获取节点(二分查找，速度更快)
	 * @param: @param  index 索引
	 * @param: @return Node
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	private Node<E> getNode(int index) {
		Node<E> node = null;
		rangeCheck(index);
		// 折半查找
		// 距离头近
		if (index < size() >> 1) {
			node = beginMarker.next;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			// 距离尾近
		} else {
			node = endMarker;
			for (int i = size(); i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}

	/**
	 * 
	 * @Title: rangeCheck
	 * @Description: 判断索引是否合法
	 * @param: @param index
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void rangeCheck(int index) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException("索引越界异常!!!");
		}
	}

	/**
	 * 
	 * @Title: addBefore
	 * @Description: 在指定节点之前插入新的节点
	 * @param: @param node Node
	 * @param: @param data E
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	private void addBefore(Node<E> node, E element) {
		Node<E> newNode = new Node<E>(element, node.prev, node);
		newNode.prev.next = newNode;
		node.prev = newNode;
		size++;
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: 删除节点
	 * @param: @param  node Node
	 * @param: @return E
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	private E remove(Node<E> node) {
		// 节点的前驱 指向 节点的后继的前驱
		node.next.prev = node.prev;
		// 节点的后继 指向 节点的前驱的后继
		node.prev.next = node.next;
		size--;
		return node.data;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = beginMarker;
		for (int i = 0; i <= size; i++) {
			if (i != 0) {
				string.append(", ");
			}

			string.append(node.data);

			node = node.next;
		}
		string.append("]");

//		Node<E> node1 = first;
//		while (node1 != null) {
//			
//			
//			node1 = node1.next;
//		}
		return string.toString();
	}

	private static class Node<E> {
		// 数据
		public E data;
		// 前驱
		public Node<E> prev;
		// 后继
		public Node<E> next;

		public Node(E data, Node<E> prev, Node<E> next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
}
```

```java
public class User {
	private int id;
	private String name;

	public User() {

	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
```

**测试**

```java
public class LinkedListTest {
	public static void main(String[] args) {
		test02();
		test03();
	}
	public static void test02() {
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
		myLinkedList.add(0);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.add(5);
		myLinkedList.add(6);
		System.out.println(myLinkedList);
		myLinkedList.remove(1);
		System.out.println(myLinkedList);
		myLinkedList.set(1, 66);
		System.out.println(myLinkedList);
		myLinkedList.add(4, 888);
		System.out.println(myLinkedList);
		myLinkedList.clear();
		System.out.println(myLinkedList);
	}

	public static void test03() {
		MyLinkedList<User> userList = new MyLinkedList<>();
		System.out.println("添加User");
		for (int i = 1; i <= 3; i++) {
			userList.add(new User(i, i + "号"));
		}
		System.out.println(userList);
		userList.remove(1);
		System.out.println(userList);
	}
}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2329c33cb1f54d71b9c888be923bb72a.png)

## 常见面试题

- 描述一下链表的数据结构？

> 链表是一种物理[存储单元](https://baike.baidu.com/item/存储单元/8727749?fromModule=lemma_inlink)上非连续、非顺序的[存储结构](https://baike.baidu.com/item/存储结构/350782?fromModule=lemma_inlink)，[数据元素](https://baike.baidu.com/item/数据元素/715313?fromModule=lemma_inlink)的逻辑顺序是通过链表中的[指针](https://baike.baidu.com/item/指针/2878304?fromModule=lemma_inlink)链接次序实现的。链表由一系列结点（链表中每一个元素称为结点）组成，结点可以在运行时动态生成。每个结点包括两个部分：一个是存储[数据元素](https://baike.baidu.com/item/数据元素?fromModule=lemma_inlink)的数据域，另一个是存储下一个结点地址的[指针](https://baike.baidu.com/item/指针/2878304?fromModule=lemma_inlink)域。 相比于[线性表](https://baike.baidu.com/item/线性表/3228081?fromModule=lemma_inlink)[顺序结构](https://baike.baidu.com/item/顺序结构/9845234?fromModule=lemma_inlink)，操作复杂。由于不必须按顺序存储，链表在插入的时候可以达到O(1)的复杂度，比另一种线性表顺序表快得多，但是查找一个节点或者访问特定编号的节点则需要O(n)的时间，而线性表和顺序表相应的时间复杂度分别是O(logn)和O(1)

- Java 中LinkedList 使用的是单向链表、双向链表还是循环链表？

> 双向链表

- 链表中数据的插入、删除、获取元素，时间复杂度是多少？

> 插入 O(1)
>
> 删除 O(1)
>
> 获取 O(n)

- 什么场景下使用链表更合适？

> 对线性表的长度或者规模难以估计；频繁做插入删除操作；构建动态性比较强的线性表

## 链表相关题目

[160. 相交链表 - 力扣（LeetCode）](https://leetcode.cn/problems/intersection-of-two-linked-lists/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       Set<ListNode> visited = new HashSet<ListNode>();
		ListNode temp = headA;
		while (temp != null) {
			visited.add(temp);
			temp = temp.next;
		}
		temp = headB;
		while (temp != null) {
			if (visited.contains(temp)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
    }
}
```

[19. 删除链表的倒数第 N 个结点 - 力扣（LeetCode）](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
	// 栈方法
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		LinkedList<ListNode> stack = new LinkedList<ListNode>();
		ListNode cur = dummy;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		for (int i = 0; i < n; ++i) {
			stack.pop();
		}
		ListNode prev = stack.peek();
		prev.next = prev.next.next;
		ListNode ans = dummy.next;
		return ans;
	}

	// 双指针
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode pre = new ListNode(0, head);
		ListNode slow = pre;
		ListNode fast = head;
		while (n-- > 0 && fast != null) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return pre.next;
	}

	// 计算链表长度
	public ListNode removeNthFromEnd3(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		int length = getLength(head);
		ListNode cur = dummy;
		for (int i = 1; i < length - n + 1; ++i) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		ListNode ans = dummy.next;
		return ans;
	}

	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			++length;
			head = head.next;
		}
		return length;
	}
```

[206. 反转链表 - 力扣（LeetCode）](https://leetcode.cn/problems/reverse-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}
	
	 /**
     * 以链表1->2->3->4->5举例
     * @param head
     * @return
     */
	public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            /*
                直到当前节点的下一个节点为空时返回当前节点
                由于5没有下一个节点了，所以此处返回节点5
             */
            return head;
        }
        //递归传入下一个节点，目的是为了到达最后一个节点
        ListNode newHead = reverseList(head.next);
                /*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head;
        head.next = null;
        return newHead;
    }
	
	public ListNode reverseList3(ListNode head) {
        ListNode temp = null;
        for (ListNode x = head; x != null; x = x.next) {
        	temp = new ListNode(x.val,temp);
        }
        return temp;
    }
```

[21. 合并两个有序链表 - 力扣（LeetCode）](https://leetcode.cn/problems/merge-two-sorted-lists/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
	// 迭代
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// 虚拟头节点
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while (list1 != null && list2 != null) {
			// 链表1节点值 小于 链表2节点值
			if (list1.val <= list2.val) {
				// 前驱节点移动
				prev.next = list1;
				// 向后移动
				list1 = list1.next;
			} else {
				prev.next = list2;
				list2 = list2.next;
			}
			prev = prev.next;
		}
		prev.next = list1 == null ? list2 : list1;
		return prehead.next;
	}

	// 递归
	public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
```

[234. 回文链表 - 力扣（LeetCode）](https://leetcode.cn/problems/palindrome-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
	// 校验
	public boolean isPalindrome(ListNode head) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			list1.add(cur.val);
			list2.add(cur.val);
			cur = cur.next;
		}
		Collections.reverse(list2);
		return list1.equals(list2);
	}

	// 双指针
	public boolean isPalindrome2(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		// 将链表的值复制到数组中
		ListNode cur = head;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}

		// 判断是否回文
		int start = 0;
		int end = list.size() - 1;
		while (start < end) {
			if (!list.get(start).equals(list.get(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// 栈
	public boolean isPalindrome3(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		for (ListNode cur = head; cur != null; cur = cur.next) {
			stack.push(cur.val);
		}
		for (ListNode cur = head; cur != null; cur = cur.next) {
			if (cur.val != stack.pop()) {
				return false;
			}
		}
		return true;
	}
```

[24. 两两交换链表中的节点 - 力扣（LeetCode）](https://leetcode.cn/problems/swap-nodes-in-pairs/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
	// 递归
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}

	// 迭代
	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp = dummy;
		while (temp.next != null && temp.next.next != null) {
			ListNode node1 = temp.next;
			ListNode node2 = temp.next.next;
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;
		}
		return dummy.next;
	}	
```

[328. 奇偶链表 - 力扣（LeetCode）](https://leetcode.cn/problems/odd-even-linked-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode evenHead = head.next;
		ListNode odd = head, even = evenHead;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
```

[445. 两数相加 II - 力扣（LeetCode）](https://leetcode.cn/problems/add-two-numbers-ii/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
	// 栈
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		ListNode ans = null;
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int a = stack1.isEmpty() ? 0 : stack1.pop();
			int b = stack2.isEmpty() ? 0 : stack2.pop();
			int cur = a + b + carry;
			carry = cur / 10;
			cur %= 10;
			ListNode node = new ListNode(cur);
			node.next = ans;
			ans = node;
		}
		return ans;
	}
```

[725. 分隔链表 - 力扣（LeetCode）](https://leetcode.cn/problems/split-linked-list-in-parts/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public ListNode[] splitListToParts(ListNode head, int k) {
		int n = 0;
		ListNode temp = head;
		while (temp != null) {
			n++;
			temp = temp.next;
		}
		int quotient = n / k, remainder = n % k;

		ListNode[] parts = new ListNode[k];
		ListNode curr = head;
		for (int i = 0; i < k && curr != null; i++) {
			parts[i] = curr;
			int partSize = quotient + (i < remainder ? 1 : 0);
			for (int j = 1; j < partSize; j++) {
				curr = curr.next;
			}
			ListNode next = curr.next;
			curr.next = null;
			curr = next;
		}
		return parts;
	}
```

[83. 删除排序链表中的重复元素 - 力扣（LeetCode）](https://leetcode.cn/problems/remove-duplicates-from-sorted-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */	
	// 迭代
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head;
		while (temp.next != null) {
			// 比较后面的值是否相等
			if (temp.val == temp.next.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head;
	}
	
	// 递归
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		head.next = deleteDuplicates2(head.next);
		// 递归寻找后面节点的值是否相等，相等就返回head的后面，否则返回head
		return head.val == head.next.val ? head.next : head;
	}
```

