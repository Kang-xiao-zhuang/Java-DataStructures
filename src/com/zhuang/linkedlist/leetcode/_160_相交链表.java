package com.zhuang.linkedlist.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: _160_相交链表
 * @Description: https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @author: KangXiaoZhuang
 * @date: 2022年11月10日 下午11:11:51
 */
public class _160_相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode l1 = headA, l2 = headB;
		while (l1 != l2) {
			l1 = (l1 == null) ? headB : l1.next;
			l2 = (l2 == null) ? headA : l2.next;
		}
		return l1;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		Set<ListNode> visited = new HashSet<ListNode>();
		ListNode temp = headA;
		while (temp != null) {
			visited.add(temp);
			temp = temp.next;
		}
		temp = headB;
		while (temp != null) {
			if (visited.contains(temp)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
}
