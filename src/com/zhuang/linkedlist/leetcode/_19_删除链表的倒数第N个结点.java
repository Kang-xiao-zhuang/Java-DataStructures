package com.zhuang.linkedlist.leetcode;

import java.util.LinkedList;

public class _19_删除链表的倒数第N个结点 {

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
}
