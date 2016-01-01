package com.study.problems;

import com.study.datastructures.BinarySearchTree;
import com.study.datastructures.TreeNode;

public class PrintTreeNodesInSpiralOrder {
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode node = bst.insert(null, 1);
		node = bst.insert(node, 2);
		node = bst.insert(node, 3);
		node = bst.insert(node, 7);
		node = bst.insert(node, 6);			
		node = bst.insert(node, 5);
		node = bst.insert(node, 4);
		
		
		System.out.println("height = "+height(node));
		boolean flip = true;
		System.out.println("Node in level order");
		for(int i=1;i<=height(node);i++){
			printTreeNodesInLevel(node,i,flip);
		}
		flip=false;
		System.out.println("Nodes in spiral");
		
		for(int i=1;i<=height(node);i++){
			printTreeNodesInLevel(node,i,flip);
			flip=!flip;
		}
		
	}

	private static void printTreeNodesInLevel(TreeNode node, int i, boolean flip) {
		if(node == null){
			return;
		}
		if(i==1){
			System.out.println(node.data);
			return;
		}if(flip){
			printTreeNodesInLevel(node.left, i-1,flip);
			printTreeNodesInLevel(node.right, i-1,flip);
		}else{
			printTreeNodesInLevel(node.right, i-1,flip);
			printTreeNodesInLevel(node.left, i-1,flip);
		}
		
	}

	private static int height(TreeNode node) {
		if(node == null){
			return 0;
		}else {
			int lHeight = height(node.left);
			int rHeight = height(node.right);
			if(lHeight>rHeight){
				return lHeight+1;
			}else{
				return rHeight+1;
			}
		}
	}

}
