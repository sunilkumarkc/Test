package com.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

//	public static void main(String[] args) {
//		List<Object> list = new ArrayList<Object>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		//list.add(1, 4);
//		
//		System.out.println(list);
//	}
	
	public static void main(String[] args) {
		Object[] array = new Object[10];
		array[0] ="1";
		array[1]="2";
		
		System.out.println(Arrays.asList(array));
	}
}
