package com.zhuang.linkedlist;

@SuppressWarnings("all")
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
		// 定义新的节点 没有前驱，后继就是head
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
