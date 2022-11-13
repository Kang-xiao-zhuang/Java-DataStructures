package com.zhuang.queue.leetcode;

/**
 * 
 * @ClassName: _2073_买票需要的时间
 * @Description:https://leetcode.cn/problems/time-needed-to-buy-tickets/
 * @author: KangXiaoZhuang
 * @date: 2022年11月13日 下午10:40:31
 */
public class _2073_买票需要的时间 {

	public int timeRequiredToBuy(int[] tickets, int k) {
		int index = 0;
		int second = 0;
		if (tickets.length == 1) {
			return tickets[0];
		}
		// 模拟购票
		while (tickets[k] != 0) {
			// 去除已经完成购票的人
			if (tickets[index] > 0) {
				tickets[index]--;
				// 时间增加
				second++;
			}
			index++;
			if (index == tickets.length) {
				// 开始下一轮购票
				index = 0;
			}
		}
		return second;
	}
}
