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
}
