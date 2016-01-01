package com.study.datastructures;

public class Stack {

	private int[] elements = null;
	private int top = -1;
	private int maxSize = 0;

	public Stack() {
		maxSize = 10;
		elements = new int[maxSize];
	}

	public void push(int item) {
		if (top < maxSize) {
			elements[++top] = item;
		}
	}

	public int pop() {
		if (top > -1) {
			return elements[top--];
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
