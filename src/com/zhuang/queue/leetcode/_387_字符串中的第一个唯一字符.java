package com.zhuang.queue.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @ClassName: _387_字符串中的第一个唯一字符
 * @Description:https://leetcode.cn/problems/first-unique-character-in-a-string/
 * @author: KangXiaoZhuang
 * @date: 2022年11月13日 下午8:51:43
 */
public class _387_字符串中的第一个唯一字符 {

	public int firstUniqChar(String s) {
		HashMap<Character, Integer> position = new HashMap<Character, Integer>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (position.containsKey(ch)) {
				position.put(ch, -1);
			} else {
				position.put(ch, i);
			}
		}
		int first = n;
		for (Map.Entry<Character, Integer> entry : position.entrySet()) {
			int pos = entry.getValue();
			if (pos != -1 && pos < first) {
				first = pos;
			}
		}
		if (first == n) {
			first = -1;
		}
		return first;
	}

	public int firstUniqChar2(String s) {
		HashMap<Character, Integer> position = new HashMap<Character, Integer>();
		Queue<Pair> queue = new LinkedList<Pair>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (!position.containsKey(ch)) {
				position.put(ch, i);
				queue.offer(new Pair(ch, i));
			} else {
				position.put(ch, -1);
				while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
					queue.poll();
				}
			}
		}
		return queue.isEmpty() ? -1 : queue.poll().pos;
	}
}

class Pair {
	char ch;
	int pos;

	public Pair(char ch, int pos) {
		super();
		this.ch = ch;
		this.pos = pos;
	}

}