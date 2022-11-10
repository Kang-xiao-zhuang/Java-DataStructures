package com.zhuang.linkedlist;

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
