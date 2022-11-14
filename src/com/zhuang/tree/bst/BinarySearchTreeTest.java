package com.zhuang.tree.bst;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree<String, String> tree = new BinarySearchTree<>();
		/*
           
            E
           / \
 		  B   G
 		 / \  /\ 
 		A	D F G
 		   /
 		  C

		 */
		tree.put("E", "E");
		tree.put("B", "B");
		tree.put("G", "G");
		tree.put("A", "A");
		tree.put("D", "D");
		tree.put("F", "F");
		tree.put("H", "H");
		tree.put("C", "C");
		System.out.println("----------------------前序遍历----------------------");
		tree.preOrder();
		System.out.println("----------------------中序遍历----------------------");
		tree.midOrder();
		System.out.println("----------------------后序遍历----------------------");
		tree.postOrder();
		System.out.println("----------------------层序遍历----------------------");
		tree.layerOrder();
		
	}
}
