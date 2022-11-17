package com.zhuang.tree.rbt;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

	// 根结点
	private Node root;
	// 结点数
	private int size;
	// 红色结点
	private static final boolean RED = false;
	// 黑色结点
	private static final boolean BLACK = true;

	// 获取当前树的根结点
	public Node getRoot() {
		return root;
	}

	// 获取当前树的结点数
	public int size() {
		return size;
	}

	// 判断当前树是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 获取当前结点的父亲结点
	private Node parentOf(Node node) {
		return node != null ? node.parent : null;
	}

	// 获取当前结点的左子结点
	private Node leftOf(Node node) {
		return node != null ? node.left : null;
	}

	// 获取当前结点的右子结点
	private Node rightOf(Node node) {
		return node != null ? node.right : null;
	}

	// 获取当前结点颜色
	private boolean colorOf(Node node) {
		return node != null ? node.color : BLACK;
	}

	// 设置当前结点颜色
	private void setColor(Node node, boolean color) {
		if (node != null) {
			node.color = color;
		}
	}

	// 结点类
	public class Node {
		// 存储键
		public Key key;
		// 存储值
		public Value value;
		// 指向父亲结点
		public Node parent;
		// 指向左子结点
		public Node left;
		// 指向右子结点
		public Node right;
		// 指向结点颜色
		public boolean color;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" + "key=" + key + ", value=" + value + ", color=" + color + "}";
		}
	}
}
