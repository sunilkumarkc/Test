package com.study.datastructures;

public class Queue {
	
	private int[] elements = null;
	private int first=-1;
	private int top=-1;
	private int maxSize=10;
	
	public Queue() {
		elements = new int[maxSize];
	}
	
	public void push(int item){
		if(top < maxSize){
			elements[++top] = item;
		}
	}
	
	public int pop(){
		if(top>-1){
			top--;
			return elements[++first];
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		
	}

}
