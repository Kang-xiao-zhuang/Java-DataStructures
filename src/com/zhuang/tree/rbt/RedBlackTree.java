package com.zhuang.tree.rbt;

import java.util.LinkedList;
import java.util.Queue;

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
			Node newNode = h.right;
			// 让h的右子节点指向x的左子节点
			h.right = newNode.left;
			// 判断x的左子节点是否为null
			if (newNode.left != null) {
				// 让x的左子节点的父节点指向h
				newNode.left.parent = h;
			}
			// 让x的父节点指向h的父节点
			newNode.parent = h.parent;
			// 判断h的父节点是否为null
			if (h.parent == null) {
				// 说明是根节点
				root = newNode;
			} else if (h.parent.left == h) { // 判断当前h子树是否为父节点的左子树
				// 如果是，修正为新的x子树
				h.parent.left = newNode;
			} else { // 判断当前h子树是否为父节点的右子树
				// 如果是，修正为新的x子树
				h.parent.right = newNode;
			}
			// x左子节点指向h节点
			newNode.left = h;
			// h节点的父节点指向x节点
			h.parent = newNode;
		}
	}

	// 右旋操作
	private void rotateRight(Node h) {
		// 判断当前节点h是否为null
		if (h != null) {
			// 获取当前节点h的左子节点x
			Node newNode = h.left;
			// 让h的左子节点指向x的右子节点
			h.left = newNode.right;
			// 判断x的右子节点是否为null
			if (newNode.right != null) {
				// 让x的右子节点的父节点指向h
				newNode.right.parent = h;
			}
			// 让x的父节点指向h的父节点
			newNode.parent = h.parent;
			// 判断h的父节点是否为null
			if (h.parent == null) {
				// 说明是根节点
				root = newNode;
			} else if (h.parent.right == h) { // 判断当前h子树是否为父节点的右子树
				// 如果是，修正为新的x子树
				h.parent.right = newNode;
			} else { // 判断当前h子树是否为父节点的左子树
				// 如果是，修正为新的x子树
				h.parent.left = newNode;
			}
			// x左子节点指向h节点
			newNode.left = h;
			// h节点的父节点指向x节点
			h.parent = newNode;
		}
	}

	public void put(Key key, Value value) {
		// 获取根节点
		Node temp = root;
		if (temp == null) {
			root = new Node(key, value);
			// 根肯定是黑色
			root.color = BLACK;
			size++;
			return;
		}
		Node parent;
		int cmp;
		do {
			parent = temp;
			cmp = key.compareTo(temp.key);
			if (cmp < 0) {
				temp = temp.left;
			} else if (cmp > 0) {
				temp = temp.right;
			} else {
				temp.value = value;
			}
		} while (temp != null);

		// 添加新的节点
		Node newNode = new Node(key, value);
		newNode.parent = parent;
		if (cmp < 0) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		// 添加后修正
		fixAfterPut(newNode);

		size++;
	}

	private void fixAfterPut(RedBlackTree<Key, Value>.Node newNode) {
		// 添加的节点必须是红色
		newNode.color = RED;
		// 因为root没有父节点，所以不能让newNode上移循环到root
		while (newNode != null && newNode != root && newNode.parent.color == RED) {
			RedBlackTree<Key, Value>.Node grandpa = parentOf(parentOf(newNode));
			if (parentOf(newNode) == leftOf(grandpa)) {
				Node uncle = rightOf(grandpa);
				if (colorOf(uncle) == RED) {
					setColor(parentOf(newNode), BLACK);
					setColor(uncle, BLACK);
					setColor(grandpa, RED);
					newNode = grandpa;
				} else {
					if (newNode == rightOf(parentOf(newNode))) {
						newNode = parentOf(newNode);
						rotateLeft(newNode);
					}
					setColor(parentOf(newNode), BLACK);
					setColor(grandpa, RED);
					rotateRight(grandpa);
				}
			} else {
				Node uncle = leftOf(grandpa);
				if (colorOf(uncle) == RED) {
					setColor(parentOf(newNode), BLACK);
					setColor(uncle, BLACK);
					setColor(grandpa, RED);
					newNode = grandpa;
				} else {
					if (newNode == leftOf(parentOf(newNode))) {
						newNode = parentOf(newNode);
						rotateRight(newNode);
					}
					setColor(parentOf(newNode), BLACK);
					setColor(grandpa, RED);
					rotateLeft(grandpa);
				}
			}
		}
		root.color = BLACK;// 根结点必须是黑结点
	}

	// 层序遍历当前树
	public void layerErgodic() {
		layerErgodic(root);
	}

	// 层序遍历指定树
	private void layerErgodic(Node x) {
		// 创建一个队列
		Queue<Node> queue = new LinkedList<>();
		// 加入指定结点
		queue.offer(x);
		// 循环弹出遍历
		while (!queue.isEmpty()) {
			// 从队列中弹出一个结点，输出当前结点的信息
			Node n = queue.poll();
			System.out.println(n);
			// 判断当前结点还有没有左子结点，如果有，则放入到nodes中
			if (n.left != null) {
				queue.offer(n.left);
			}
			// 判断当前结点还有没有右子结点，如果有，则放入到nodes中
			if (n.right != null) {
				queue.offer(n.right);
			}
		}
	}

	// 获取指定节点
	public Node getNode(Key key) {
		Node temp = root;
		while (temp != null) {
			int cmp = key.compareTo(temp.key);
			if (cmp < 0) {
				temp = temp.left;
			} else if (cmp > 0) {
				temp = temp.right;
			} else {
				return temp;
			}
		}
		return null;
	}

	// 获取最小节点
	public Node getMinNode() {
		Node temp = root;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}
		}
		return temp;
	}

	// 获取最大节点
	public Node getMaxNode() {
		Node temp = root;
		if (temp != null) {
			while (temp.right != null) {
				temp = temp.right;
			}
		}
		return temp;
	}

	// 获取指定节点的前驱节点
	public Node predecessor(Node node) {
		if (node == null) {
			return null;
		} else if (node.left != null) {
			Node temp = node.left;
			while (temp.right != null) {
				temp = temp.right;
			}
			return temp;
		} else {
			Node temp = node.parent;
			Node x = node;
			while (temp != null && x == temp.left) {
				x = temp;
				temp = temp.parent;
			}
			return temp;
		}
	}

	// 获取指定节点的后驱节点
	public Node successor(Node node) {
		if (node == null) {
			return null;
		} else if (node.right != null) {
			Node temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
		} else {
			Node temp = node.parent;
			Node x = node;
			while (temp != null && x == temp.right) {
				x = temp;
				temp = temp.parent;
			}
			return temp;
		}
	}

	// 删除操作
	public Value delete(Key key) {
		Node p = getNode(key);
		if (p == null)
			return null;
		Value oldValue = p.value;
		deleteNode(p);
		return oldValue;
	}

	// 真正删除
	private void deleteNode(Node node) {
		size--;

		// 4、要删除的结点有2个孩子，肯定有左孩子，肯定有右孩子
		if (node.left != null && node.right != null) {
			// 找到前驱结点，然后替换要删除结点的键值
			Node s = predecessor(node);
			node.key = s.key;
			node.value = s.value;
			// 替换完成以后，指向前驱结点为删除做准备
			node = s;
		}

		// 3、要删除的结点有1个孩子，可能有左孩子，可能有右孩子
		Node replacement = (node.left != null ? node.left : node.right);
		if (replacement != null) {
			// 让左右子结点连接到node的父结点上
			replacement.parent = node.parent;
			if (node.parent == null) {
				root = replacement;
			} else if (node == node.parent.left) {
				node.parent.left = replacement;
			} else {
				node.parent.right = replacement;
			}
			// 释放当前node结点所有指向等待回收
			node.left = node.right = node.parent = null;

			// 如果当前删除的是黑结点需修正
			if (node.color == BLACK) {
				fixAfterDelete(replacement);
			}
		}
		// 2、要删除的结点是树根结点，此时直接删除即可。（树根结点永远黑色，删除完了就完了，还保持啥平衡）
		else if (node.parent == null) {
			root = null;
		}
		// 1、要删除的结点是叶子结点，此时直接删除即可。（如果删除的是黑色结点，我们要先调整，然后再删除）
		else {
			// 先调整
			if (node.color == BLACK) {
				fixAfterDelete(node);
			}
			// 再删除
			if (node.parent != null) {
				if (node == node.parent.left) {
					node.parent.left = null;
				} else if (node == node.parent.right) {
					node.parent.right = null;
				}
				node.parent = null;
			}
		}
	}

	private void fixAfterDelete(Node node) {
		// 那么在此之前要处理的必定是 node != root && colorOf(node) == BLACK
		while (node != root && colorOf(node) == BLACK) {
			// node是左孩子的情况
			if (node == leftOf(parentOf(node))) {
				// 获取当前的兄弟结点
				Node brother = rightOf(parentOf(node));

				// 找到真正的兄弟结点
				if (colorOf(brother) == RED) {
					setColor(brother, BLACK);
					setColor(parentOf(node), RED);
					rotateLeft(parentOf(node));
					brother = rightOf(parentOf(node));
				}

				// 这个兄弟结点帮不了
				if (colorOf(leftOf(brother)) == BLACK && colorOf(rightOf(brother)) == BLACK) {
					setColor(brother, RED);
					node = parentOf(node);
				}
				// 这个兄弟结点帮得了
				else {
					// 判断当前结构是不是需要调整，找到真正的兄弟结点
					if (colorOf(rightOf(brother)) == BLACK) {
						setColor(leftOf(brother), BLACK);
						setColor(brother, RED);
						rotateRight(brother);
						brother = rightOf(parentOf(node));
					}
					// 让老父亲去顶替被删除结点，让亲兄弟去顶替老父亲
					setColor(brother, colorOf(parentOf(node)));
					setColor(parentOf(node), BLACK);
					setColor(rightOf(brother), BLACK);
					rotateLeft(parentOf(node));
					// 这种情况，调整一次即可，node=root代表跳出当前循环
					node = root;
				}
			}
			// node是右孩子的情况
			else {
				// 获取当前的兄弟结点
				Node brother = leftOf(parentOf(node));

				// 找到真正的兄弟结点
				if (colorOf(brother) == RED) {
					setColor(brother, BLACK);
					setColor(parentOf(node), RED);
					rotateRight(parentOf(node));
					brother = leftOf(parentOf(node));
				}

				// 这个兄弟结点帮不了
				if (colorOf(rightOf(brother)) == BLACK && colorOf(leftOf(brother)) == BLACK) {
					setColor(brother, RED);
					node = parentOf(node);
				}
				// 这个兄弟结点帮得了
				else {
					// 判断当前结构是不是需要调整，找到真正的兄弟结点
					if (colorOf(leftOf(brother)) == BLACK) {
						setColor(rightOf(brother), BLACK);
						setColor(brother, RED);
						rotateLeft(brother);
						brother = leftOf(parentOf(node));
					}
					// 让老父亲去顶替被删除结点，让亲兄弟去顶替老父亲
					setColor(brother, colorOf(parentOf(node)));
					setColor(parentOf(node), BLACK);
					setColor(leftOf(brother), BLACK);
					rotateRight(parentOf(node));
					// 这种情况，调整一次即可，node=root代表跳出当前循环
					node = root;
				}
			}
		}

		// 如果当前结点是红色，那么立即修改为黑色
		// 还有一种情况就是为了保证根结点root始终是黑色，因为replacement最后有可能成为根结点
		setColor(node, BLACK);
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
