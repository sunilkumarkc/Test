package com.study.problems;

import com.fedex.datastructures.LinkedList;
import com.fedex.datastructures.Node;

public class FindNthNodeFromLastLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		int nodeAtNthPosition = findNodeAtNthPosition(list, 7);
		System.out.println(nodeAtNthPosition);
	}

	private static int findNodeAtNthPosition(LinkedList<Integer> list, int i) {
		Node<Integer> current = list.head;
		Node<Integer> ptrA = current;
		Node<Integer> ptrB = current;
		while (current != null && i > 0) {			
			current = current.next;
			ptrB = current;
			i--;
		}
		while (ptrB != null) {
			ptrB = ptrB.next;
			ptrA = ptrA.next;
		}
		return ptrA.data;
	}

}
