package com.study;

public class EqualsTest {
	public static void main(String[] args) {
		
		String name= "Leo";
		String fname ="Leo";
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		
//		System.out.println(name == fname);
//		System.out.println(name.equals(fname));
//		System.out.println(i1 == i2);
//		System.out.println(i1.equals(i2));
		
		
		Student s1= new Student();
		s1.setName("Derrick");
		s1.setSubject1(100);
		
		Student s2= new Student();
		s2.setName("Derrick");
		s2.setSubject1(100);
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		
				
		
	}

}
