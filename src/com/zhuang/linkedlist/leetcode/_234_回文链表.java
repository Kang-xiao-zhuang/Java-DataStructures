package com.zhuang.linkedlist.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 
 * @ClassName: _234_回文链表
 * @Description:https://leetcode.cn/problems/palindrome-linked-list/
 * @author: KangXiaoZhuang
 * @date: 2022年11月11日 下午10:21:23
 */
public class _234_回文链表 {

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
}
