package com.zhuang.sqlist;

/**
 * 
 * @ClassName: List
 * @Description:List接口
 * @author: KangXiaoZhuang
 * @date: 2022年11月7日 下午10:55:39
 */
public interface List<E> {
	void clear();

	int size();

	boolean isEmpty();

	E get(int index);

	int indexOf(E element);

	E set(int index, E newElement);

	boolean add(E addElement);

	boolean contains(E element);

	void add(int index, E addElement);

	E remove(int index);
}
