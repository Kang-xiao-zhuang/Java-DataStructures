package com.zhuang.linkedlist.leetcode;

/**
 * 
 * @Title: oddEvenList
 * @Description: https://leetcode.cn/problems/odd-even-linked-list/
 * @param: @param  head
 * @param: @return
 * @author: KangXiaoZhuang
 * @email: ITkxz0830@163.com
 */
public class _328_奇偶链表 {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode evenHead = head.next;
		ListNode odd = head, even = evenHead;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
