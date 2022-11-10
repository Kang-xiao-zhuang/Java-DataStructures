package com.zhuang.linkedlist;

import com.zhuang.sqlist.User;

public class LinkedListTest {
	public static void main(String[] args) {
		test03();
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
		for (int i = 0; i < 10; i++) {
			userList.add(new User(i, i + "号"));
		}
		System.out.println(userList);
		userList.remove(1);
		System.out.println(userList);
	}
}
