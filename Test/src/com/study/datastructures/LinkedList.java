package com.study.datastructures;

public class LinkedList<T> {

	

	public Node<T> head = null;

	// add item at the beginning
	public void addFirst(T item) {
		Node temp = new Node();
		temp.data = item;
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
	}
	//add at the last
	public void addLast(T item) {
		Node newNode = new Node();
		newNode.data = item;
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	//add at a position
	public void addAtPosition(T item, int position) {
		Node newNode = new Node();
		newNode.data = item;
		Node temp = head;
		Node current= null;
		while (temp != null && --position > 0) {
			current = temp;
			temp = temp.next;
		}
		if (temp.next == null) {
			temp.next = newNode;
		} else {
			newNode.next = temp;
			current.next = newNode;
		}
	}
	//remove from position
	public void removeAtPosition(int position) {
		Node current = head;
		Node prev = null;
		while (current != null && --position > 0) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;

	}
	//reverse the linked list
	public void reverse() {
		Node next = null;
		Node current = head;
		Node prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	// print the linked list
	public void print() {
		Node temp = head;
		System.out.println("\n");
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}
	
	public void printRecursive(Node head){
		
		if(head!=null){
			System.out.print(head.data+" -> ");
			printRecursive(head.next);
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// list.addFirst(1);
		// list.addFirst(2);
		// list.addFirst(3);
		// list.addFirst(4);
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addAtPosition(5, 2);
		list.addAtPosition(5, 5);

		list.print();
		list.removeAtPosition(2);
		list.print();
		list.reverse();
		list.printRecursive(list.head);
	}

}
