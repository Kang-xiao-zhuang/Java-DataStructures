package com.zhuang.stack.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @ClassName: _503_下一个更大元素II
 * @Description:https://leetcode.cn/problems/next-greater-element-ii/
 * @author: KangXiaoZhuang
 * @date: 2022年11月12日 下午8:05:57
 */
public class _503_下一个更大元素II {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 1 };
		nextGreaterElements(nums);
	}

	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n * 2; i++) {
			int num = nums[i % n];
			while (!stack.isEmpty() && nums[stack.peek()] < num) {
				res[stack.pop()] = num;
			}
			if (i < n) {
				stack.push(i);
			}
		}
		return res;
	}
}
