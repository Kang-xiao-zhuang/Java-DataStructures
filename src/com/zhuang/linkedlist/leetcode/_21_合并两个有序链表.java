package com.zhuang.linkedlist.leetcode;

/**
 * 
 * @ClassName: _21_合并两个有序链表
 * @Description:https://leetcode.cn/problems/merge-two-sorted-lists/
 * @author: KangXiaoZhuang
 * @date: 2022年11月11日 上午11:13:37
 */
public class _21_合并两个有序链表 {
	// 迭代
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// 虚拟头节点
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while (list1 != null && list2 != null) {
			// 链表1节点值 小于 链表2节点值
			if (list1.val <= list2.val) {
				// 前驱节点移动
				prev.next = list1;
				// 向后移动
				list1 = list1.next;
			} else {
				prev.next = list2;
				list2 = list2.next;
			}
			prev = prev.next;
		}
		prev.next = list1 == null ? list2 : list1;
		return prehead.next;
	}

	// 递归
	public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
}
