package com.study;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> lst = new LinkedList<String>();
		lst.add("Hello");
		lst.add("World");
		lst.remove(1);
		
		for (String str:lst){
			System.out.println(str);
		}
	}
}
