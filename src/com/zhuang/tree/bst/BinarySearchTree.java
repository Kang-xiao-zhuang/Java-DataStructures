package com.zhuang.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @ClassName: BinarySearchTree
 * @Description:二叉搜索树的Java代码实现
 * @author: KangXiaoZhuang
 * @date: 2022年11月14日 下午3:01:08
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	// 根结点
	private Node root;
	// 结点数
	private int N;

	// 获取当前树的结点数
	public int size() {
		return N;
	}

	// 判断当前树是否为空
	public boolean isEmpty() {
		return N == 0;
	}

	// 向当前树中添加结点
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	// 向指定树中添加结点
	private Node put(Node node, Key key, Value value) {
		// 如果node子树为空，直接返回新结点
		if (node == null) {
			N++;
			return new Node(key, value);
		}
		// 如果node子树不空，根据情况来插入
		int cmp = key.compareTo(node.key);
		// 小于,往左插
		if (cmp < 0) {
			node.left = put(node.left, key, value);
			// 大于,往右插
		} else if (cmp > 0) {
			node.right = put(node.right, key, value);
			// 相等,覆盖
		} else {
			node.value = value;
		}
		return node;
	}

	// 在当前树中根据Key获取Value
	public Value get(Key key) {
		return get(root, key);
	}

	// 在指定树中根据Key获取Value
	private Value get(Node node, Key key) {
		// 如果node子树为空，直接返回null
		if (node == null) {
			return null;
		}
		// 如果node子树不空，根据情况返回
		int cmp = key.compareTo(node.key);
		// 小于,往左找
		if (cmp < 0) {
			return get(node.left, key);
			// 大于,往右找
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			// 相等,直接返回
			return node.value;
		}
	}

	// 在当前树中获取最小的Key
	public Key min() {
		return min(root).key;
	}

	// 在指定树中获取最小的结点
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}

	// 在当前树中获取最大的Key
	public Key max() {
		return max(root).key;
	}

	// 在指定树中获取最大的结点
	private Node max(Node node) {
		if (node.right == null) {
			return node;
		}
		return max(node.right);
	}

	// 获取当前树最大深度
	public int maxDepth() {
		return maxDepth(root);
	}

	// 获取指定树最大深度
	private int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		// node结点的最大深度
		int max = 0;
		// 左子树的最大深度
		int maxL = 0;
		// 右子树的最大深度
		int maxR = 0;
		// 计算node结点左子树的最大深度
		if (node.left != null) {
			maxL = maxDepth(node.left);
		}
		// 计算node结点右子树的最大深度
		if (node.right != null) {
			maxR = maxDepth(node.right);
		}
		// 比较左子树和右子树最大深度
		max = maxL > maxR ? maxL + 1 : maxR + 1;
		return max;
	}

	// 删除当前树中最小的结点
	public void deleteMin() {
		root = deleteMin(root);
	}

	// 删除指定树中最小的结点
	private Node deleteMin(Node node) {
		if (node.left == null) {
			N--;
			return node.right;
		}
		node.left = deleteMin(node.left);
		return node;
	}

	// 删除当前树中最大的结点
	public void deleteMax() {
		root = deleteMax(root);
	}

	// 删除指定树中最大的结点
	private Node deleteMax(Node node) {
		if (node.right == null) {
			N--;
			return node.left;
		}
		node.right = deleteMin(node.right);
		return node;
	}

	// 删除当前树中指定Key对应的结点
	public void delete(Key key) {
		root = delete(root, key);
	}

	// 删除指定树中指定Key对应的结点
	private Node delete(Node node, Key key) {
		// 如果node子树为空，直接返回null
		if (node == null) {
			return null;
		}
		// 如果node子树不空，根据情况删除
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = delete(node.left, key);
		} else if (cmp > 0) {
			node.right = delete(node.right, key);
		} else {
			// 删除左叶子结点或有一个孩子的情况
			if (node.left == null) {
				N--;
				return node.right;
			}
			// 删除右叶子结点或有一个孩子的情况
			else if (node.right == null) {
				N--;
				return node.left;
			}
			// 删除非叶子结点
			else {
				Node t = node;
				node = min(t.right);
				node.right = deleteMin(t.right);
				node.left = t.left;
			}
		}
		return node;
	}

	// 前序遍历当前树
	public void preOrder() {
		preOrder(root);
	}

	// 前序遍历指定树
	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		// 输出根结点
		System.out.println(node);
		// 遍历左子树
		if (node.left != null) {
			preOrder(node.left);
		}
		// 遍历右子树
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	// 中序遍历当前树
	public void midOrder() {
		midOrder(root);
	}

	// 中序遍历指定树
	private void midOrder(Node node) {
		if (node == null) {
			return;
		}
		// 遍历左子树
		if (node.left != null) {
			midOrder(node.left);
		}
		// 输出根结点
		System.out.println(node);
		// 遍历右子树
		if (node.right != null) {
			midOrder(node.right);
		}
	}

	// 后序遍历当前树
	public void postOrder() {
		postOrder(root);
	}

	// 后序遍历指定树
	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		// 遍历左子树
		if (node.left != null) {
			postOrder(node.left);
		}
		// 遍历右子树
		if (node.right != null) {
			postOrder(node.right);
		}
		// 输出根结点
		System.out.println(node);
	}

	// 层序遍历当前树
	public void layerOrder() {
		layerOrder(root);
	}

	// 层序遍历指定树
	private void layerOrder(Node node) {
		// 创建一个队列
		Queue<Node> queue = new LinkedList<>();
		// 加入指定节点
		queue.offer(node);
		// 循环弹出遍历
		while (!queue.isEmpty()) {
			// 从队列中弹出一个结点，输出当前结点的信息
			Node n = queue.poll();
			System.out.println(n);
			// 判断当前结点还有没有左子结点，如果有，则放入到queue中
			if (n.left != null) {
				queue.offer(n.left);
			}
			// 判断当前结点还有没有右子结点，如果有，则放入到queue中
			if (n.right != null) {
				queue.offer(n.right);
			}
		}
	}

	private class Node { // 结点类
		// 存储键
		public Key key;
		// 存储值
		public Value value;
		// 指向左子结点
		public Node left;
		// 指向右子结点
		public Node right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", left=" + left + ", right=" + right + "]";
		}

		/*
		 * @Override public String toString() { return "Node{" + "key=" + key +
		 * ", value=" + value + "}"; }
		 */

	}
}
