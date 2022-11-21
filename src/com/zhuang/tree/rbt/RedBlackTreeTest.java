package com.zhuang.tree.rbt;

public class RedBlackTreeTest {
	public static void main(String[] args) {
		RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
		rbt.put(1, 1);
		rbt.put(2, 2);
		rbt.put(3, 3);
		rbt.put(4, 4);
		rbt.put(5, 5);
		rbt.put(6, 6);
		rbt.put(7, 7);
		rbt.put(8, 8);
		rbt.put(9, 9);
		rbt.put(10, 10);
		rbt.put(11, 11);
		rbt.put(12, 12);

		rbt.delete(1);
		rbt.delete(3);
		rbt.delete(5);
		rbt.delete(7);
		rbt.delete(9);
		rbt.delete(11);
		rbt.layerErgodic();
	}
}
