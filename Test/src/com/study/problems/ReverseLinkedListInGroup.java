package com.study.problems;

import com.study.datastructures.LinkedList;
import com.study.datastructures.Node;

public class ReverseLinkedListInGroup {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		linkedList.addLast(6);
		linkedList.addLast(7);
		linkedList.addLast(8);
		linkedList.addLast(9);
		linkedList.print();
		linkedList.head = reverseLinkedList(linkedList.head, 3);
		linkedList.print();

	}

	private static Node<Integer> reverseLinkedList(Node<Integer> head, int i) {

		Node<Integer> current = head;
		Node<Integer> prev = null;
		Node<Integer> next = null;
		int k = i;
		while (current != null && k > 0) {

				next = current.next;
				current.next = prev;//null<-1<-2<-3
				prev = current;
				current = next;
				k--;

			
		}
		if(next!=null){
			head.next=reverseLinkedList(next, i);
		}
		return prev;

	}

}
