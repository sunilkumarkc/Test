package com.study.datastructures;

public class BinarySearchTree {
	
	public TreeNode insert(TreeNode root, int data){
		if(root == null){
			root = new TreeNode();
			root.data =  data;
			return root;
		}else if(data < root.data){
			root.left =  insert(root.left, data);
		}else{
			root.right = insert(root.right,data);
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode node = bst.insert(null, 4);
		node = bst.insert(node, 1);
		node = bst.insert(node, 5);
		node = bst.insert(node, 3);
		node = bst.insert(node, 6);			
		node = bst.insert(node, 2);
		
		bst.inOrderTraversal(node);
		bst.preOrderTraversal(node);
		
	}
	
	public void inOrderTraversal(TreeNode root){
		if(root ==null )
			return;
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}
	
	public void preOrderTraversal(TreeNode root){
		if(root ==null )
			return;
		System.out.println(root.data);
		preOrderTraversal(root.left);		
		preOrderTraversal(root.right);
	}

}
