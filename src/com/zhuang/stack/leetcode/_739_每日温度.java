package com.zhuang.stack.leetcode;

import java.util.Stack;

/**
 * 
 * @ClassName: _739_每日温度
 * @Description:https://leetcode.cn/problems/daily-temperatures/
 * @author: KangXiaoZhuang
 * @date: 2022年11月12日 下午7:53:06
 */
public class _739_每日温度 {

	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int len = temperatures.length;
		int[] ans = new int[len];
		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int temp = stack.pop();
				ans[temp] = i - temp;
			}
			stack.add(i);
		}
		return ans;
	}

}
