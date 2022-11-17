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

	// 左旋操作
	private void rotateLeft(Node h) {
		// 判断当前节点h是否为null
		if (h != null) {
			// 获取当前节点h的右子节点x
			Node x = h.right;
			// 让h的右子节点指向x的左子节点
			h.right = x.left;
			// 判断x的左子节点是否为null
			if (x.left != null) {
				// 让x的左子节点的父节点指向h
				x.left.parent = h;
			}
			// 让x的父节点指向h的父节点
			x.parent = h.parent;
			// 判断h的父节点是否为null
			if (h.parent == null) {
				// 说明是根节点
				root = x;
			} else if (h.parent.left == h) { // 判断当前h子树是否为父节点的左子树
				// 如果是，修正为新的x子树
				h.parent.left = x;
			} else { // 判断当前h子树是否为父节点的右子树
				// 如果是，修正为新的x子树
				h.parent.right = x;
			}
			// x左子节点指向h节点
			x.left = h;
			// h节点的父节点指向x节点
			h.parent = x;
		}
	}

	// 右旋操作
	private void rotateRight(Node h) {
		// 判断当前节点h是否为null
		if (h != null) {
			// 获取当前节点h的左子节点x
			Node x = h.left;
			// 让h的左子节点指向x的右子节点
			h.left = x.right;
			// 判断x的右子节点是否为null
			if (x.right != null) {
				// 让x的右子节点的父节点指向h
				x.right.parent = h;
			}
			// 让x的父节点指向h的父节点
			x.parent = h.parent;
			// 判断h的父节点是否为null
			if (h.parent == null) {
				// 说明是根节点
				root = x;
			} else if (h.parent.right == h) { // 判断当前h子树是否为父节点的右子树
				// 如果是，修正为新的x子树
				h.parent.right = x;
			} else { // 判断当前h子树是否为父节点的左子树
				// 如果是，修正为新的x子树
				h.parent.left = x;
			}
			// x左子节点指向h节点
			x.left = h;
			// h节点的父节点指向x节点
			h.parent = x;
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
