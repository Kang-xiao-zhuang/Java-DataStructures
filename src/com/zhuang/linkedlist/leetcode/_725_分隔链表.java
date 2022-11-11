package com.zhuang.linkedlist.leetcode;

/**
 * 
 * @ClassName: _725_分隔链表
 * @Description:https://leetcode.cn/problems/split-linked-list-in-parts/
 * @author: KangXiaoZhuang
 * @date: 2022年11月11日 下午10:20:33
 */
public class _725_分隔链表 {
	public ListNode[] splitListToParts(ListNode head, int k) {
		int n = 0;
		ListNode temp = head;
		while (temp != null) {
			n++;
			temp = temp.next;
		}
		int quotient = n / k, remainder = n % k;

		ListNode[] parts = new ListNode[k];
		ListNode curr = head;
		for (int i = 0; i < k && curr != null; i++) {
			parts[i] = curr;
			int partSize = quotient + (i < remainder ? 1 : 0);
			for (int j = 1; j < partSize; j++) {
				curr = curr.next;
			}
			ListNode next = curr.next;
			curr.next = null;
			curr = next;
		}
		return parts;
	}
}
