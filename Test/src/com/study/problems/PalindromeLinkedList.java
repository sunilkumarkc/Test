package com.study.problems;

import com.study.datastructures.LinkedList;
import com.study.datastructures.Node;

public class PalindromeLinkedList {
	
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addLast("aba");
		linkedList.addLast("cd");
		linkedList.addLast("efe");
		linkedList.addLast("d");
		linkedList.addLast("aba");
		linkedList.print();
		System.out.println(new PalindromeLinkedList().isPalindrome(linkedList));

	}
	
	public boolean isPalindrome(LinkedList<String> linkedList){
		Node<String> current = linkedList.head;
		java.util.Stack<Character> stack = new java.util.Stack<Character>();
		while(current!=null){
			if (current.data!=null){
				for(int i=0;i<current.data.length();i++){
					stack.push(current.data.charAt(i));
				}
			}
			current = current.next;
		}
		current = linkedList.head;
		while(current!=null){
			if (current.data!=null){
				for(int i=0;i<current.data.length();i++){
					if(!stack.pop().equals(current.data.charAt(i))){
						return false;
					}
				}
			}
			current= current.next;
		}
	return true;
		
	}

}
