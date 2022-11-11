package com.zhuang.linkedlist.leetcode;

/**
 * 
 * @ClassName: _83_删除排序链表中的重复元素
 * @Description:https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @author: KangXiaoZhuang
 * @date: 2022年11月11日 上午11:22:32
 */
public class _83_删除排序链表中的重复元素 {
	// 迭代
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head;
		while (temp.next != null) {
			// 比较后面的值是否相等
			if (temp.val == temp.next.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head;
	}
	
	// 递归
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		head.next = deleteDuplicates2(head.next);
		// 递归寻找后面节点的值是否相等，相等就返回head的后面，否则返回head
		return head.val == head.next.val ? head.next : head;
	}
}
