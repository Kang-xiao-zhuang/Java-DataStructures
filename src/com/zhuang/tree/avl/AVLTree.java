package com.zhuang.tree.avl;

public class AVLTree<Key extends Comparable<Key>, Value> {

	private Node root; // 根结点
	private int size; // 结点数

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

	// 获取当前结点高度
	private int heightOf(Node node) {
		return node != null ? node.height : 0;
	}

	// 获取最高的子结点
	private Node tallerOf(Node node) {
		Node parent = parentOf(node);
		Node left = leftOf(node);
		Node right = rightOf(node);
		if (heightOf(left) > heightOf(right))
			return left;
		if (heightOf(left) < heightOf(right))
			return right;
		return (left == leftOf(parent)) ? left : right;
	}

	// 更新当前结点高度
	private void updateHeight(Node node) {
		if (node != null) {
			node.height = Math.max(heightOf(leftOf(node)), heightOf(rightOf(node))) + 1;
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
		// 指向结点高度
		public int height;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.height = 1;
		}

		@Override
		public String toString() {
			return "Node{" + "key=" + key + ", value=" + value + ", height=" + height + "}";
		}
	}
}
