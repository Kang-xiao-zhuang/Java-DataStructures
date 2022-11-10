package com.zhuang.linkedlist;

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
