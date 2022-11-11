package com.zhuang.linkedlist.leetcode;

/**
 * 
 * @ClassName: _24_两两交换链表中的节点
 * @Description:https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author: KangXiaoZhuang
 * @date: 2022年11月11日 下午2:10:49
 */
public class _24_两两交换链表中的节点 {
	// 递归
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}

	// 迭代
	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp = dummy;
		while (temp.next != null && temp.next.next != null) {
			ListNode node1 = temp.next;
			ListNode node2 = temp.next.next;
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;
		}
		return dummy.next;
	}
}
