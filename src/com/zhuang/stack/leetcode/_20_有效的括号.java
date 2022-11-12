package com.zhuang.stack.leetcode;

import java.util.Stack;

/**
 * 
 * @ClassName: _20_有效的括号
 * @Description:https://leetcode.cn/problems/valid-parentheses/
 * @author: KangXiaoZhuang
 * @date: 2022年11月12日 下午7:51:24
 */
public class _20_有效的括号 {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || c != stack.pop()) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
