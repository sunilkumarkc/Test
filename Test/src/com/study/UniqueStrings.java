package com.study;

public class UniqueStrings {
	
	public static void main(String[] args) {
		String input = "Helo";
		boolean[] asciichars = new boolean[128];
		for(int i=0;i<input.length();i++){
			int ascciVal = input.charAt(i);
			if(asciichars[ascciVal]){
				System.out.println("character already found");
				return;
			}else{
				asciichars[ascciVal]=true; 
			}
			
		}
		System.out.println("Characters are unique");
	}

}
