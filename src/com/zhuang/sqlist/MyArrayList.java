package com.zhuang.sqlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @ClassName: MyArrayList
 * @Description: 自定义ArrayList
 * @author: KangXiaoZhuang
 * @date: 2022年11月7日 下午10:55:12
 */
public class MyArrayList<E> implements Iterable<E>, List<E> {

	// 默认大小
	private static final int DEFAULT_CAPACITY = 10;
	// 找不到值为-1
	public static final int ELEMENT_NOT_FOUND = -1;
	// 集合大小
	private int size;
	// 存放元素的数组
	private E[] elements;

	// 构造方法
	public MyArrayList() {
		clear();
	}

	/**
	 * 
	 * @Title: clear
	 * @Description: 清空集合
	 * @param:
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void clear() {
		size = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	/**
	 * 
	 * @Title: ensureCapacity
	 * @Description: 开辟一个新的数组，扩容操作
	 * @param: @param newCapacity
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < size) {
			return;
		}
		E[] oldElements = elements;
		// 新建一个数组
		elements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			elements[i] = oldElements[i];
		}
	}

	/**
	 * 
	 * @Title: size
	 * @Description: 返回集合大小
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @Title: isEmpty
	 * @Description: 返回集合是否为空
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * 
	 * @Title: trimToSize
	 * @Description: 修改指定大小
	 * @param:
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void trimToSize() {
		ensureCapacity(size());
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 获取指定索引的元素
	 * @param: @param  index
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 
	 * @Title: indexOf
	 * @Description: 查看元素的索引
	 * @param: @param  element
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i]))
					return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 
	 * @Title: contains
	 * @Description: 是否包含指定元素
	 * @param: @param  element
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	/**
	 * 
	 * @Title: set
	 * @Description: 修改指定索引的值
	 * @param: @param  index
	 * @param: @param  newElement
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E set(int index, E newElement) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = newElement;
		return old;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 直接从尾部插入
	 * @param: @param  addElement 添加的元素
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public boolean add(E addElement) {
		add(size(), addElement);
		return true;
	}

	/**
	 * 
	 * @Title: add
	 * @Description: 指定索引位置添加元素
	 * @param: @param index 索引
	 * @param: @param addElement 添加的元素
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public void add(int index, E addElement) {
		// 先判断是否需要扩容
		if (elements.length == size()) {
			ensureCapacity(size() * 2 + 1);
		}
		// 集合元素往后移动
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = addElement;
		size++;
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: 删除指定索引的元素
	 * @param: @param  index
	 * @param: @return
	 * @author: KangXiaoZhuang
	 * @email: ITkxz0830@163.com
	 */
	public E remove(int index) {
		E removeElement = elements[index];
		// 集合的元素统一向前移动
		for (int i = index; i < size() - 1; i++) {
			elements[i] = elements[i + 1];
		}
		// 长度减1
		size--;

		return removeElement;
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
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException("索引越界异常!!!");
		}
	}

	public void print() {
		for (E e : elements) {
			if (e != null) {
				System.out.print(e + ",");
			}
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<E>(this);
	}

	class ArrayListIterator<E> implements Iterator<E> {

		private int current = 0;

		private MyArrayList<E> myArrayList;

		public ArrayListIterator(MyArrayList<E> myArrayList) {
			this.myArrayList = myArrayList;
		}

		@Override
		public boolean hasNext() {
			// 判断是否还有下一个
			return current < myArrayList.size();
		}

		@Override
		public E next() {
			// 看是否还有下一个
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return myArrayList.elements[current++];
		}

		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}
}
