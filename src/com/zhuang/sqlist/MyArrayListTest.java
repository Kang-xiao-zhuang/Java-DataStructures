package com.zhuang.sqlist;

import java.util.Iterator;

public class MyArrayListTest {

	public static void main(String[] args) {
		test01();
		System.out.println("-------------------------------------");
		test02();
	}

	public static void test01() {
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		System.out.println("添加元素");
		for (int i = 0; i < 10; i++) {
			myArrayList.add(i);
		}
		myArrayList.print();
		System.out.println();
		System.out.println("清空集合");
		myArrayList.clear();
		System.out.println("集合大小:" + myArrayList.size());
		System.out.println("添加元素");
		for (int i = 10; i < 20; i++) {
			myArrayList.add(i);
		}
		myArrayList.print();
		System.out.println();
		System.out.println("集合大小:" + myArrayList.size());
		System.out.println("集合是否为空:" + myArrayList.isEmpty());
		System.out.println("索引5的元素是:" + myArrayList.get(5));
		System.out.println("删除索引5的元素:" + myArrayList.remove(5));
		myArrayList.print();
		System.out.println();
		System.out.println("在索引0处添加元素666:");
		myArrayList.set(0, 666);
		myArrayList.print();
		System.out.println();

		System.out.println("迭代器遍历");
		// 迭代器遍历
		Iterator<Integer> iterator = myArrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void test02() {
		MyArrayList<User> userList = new MyArrayList<User>();
		System.out.println("添加User");
		for (int i = 0; i < 10; i++) {
			userList.add(new User(i, i + "号"));
		}
		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
