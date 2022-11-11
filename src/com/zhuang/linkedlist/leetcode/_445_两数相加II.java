package com.zhuang.linkedlist.leetcode;

import java.util.Stack;

/**
 * 
 * @ClassName: _445_两数相加II
 * @Description:https://leetcode.cn/problems/add-two-numbers-ii/
 * @author: KangXiaoZhuang
 * @date: 2022年11月11日 下午10:21:02
 */
public class _445_两数相加II {
	// 栈
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		ListNode ans = null;
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int a = stack1.isEmpty() ? 0 : stack1.pop();
			int b = stack2.isEmpty() ? 0 : stack2.pop();
			int cur = a + b + carry;
			carry = cur / 10;
			cur %= 10;
			ListNode node = new ListNode(cur);
			node.next = ans;
			ans = node;
		}
		return ans;
	}
}
