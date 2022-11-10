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

## LinkedList类的实现

考虑设计方面，提供几个类

1. LinkedList类本身，包含两端的链，表的大小以及一些方法
2. Node类，私有的嵌套类，一个节点包含数据以及前一个节点的链和到下一个节点的类，适当的构造方法

```java
public class MyLinkedList<E> implements MyList<E> {

	// 找不到值为-1
	public static final int ELEMENT_NOT_FOUND = -1;
	// 链表大小
	private int size;

	// 修改次数
	private int modCount = 0;

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
		// 修改次数加1
		modCount++;
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
		modCount++;
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
		modCount++;
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

