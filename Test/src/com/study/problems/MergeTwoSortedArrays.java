package com.study.problems;

public class MergeTwoSortedArrays {
	
	public int[] mergeTwoArrays(int[] first,int[] second,int firstEnd,int secondEnd){
		int modifiedEnd = firstEnd+secondEnd+1;
		while (secondEnd>=0){
			if(second[secondEnd]>=first[firstEnd]){
				first[modifiedEnd] = second[secondEnd];
				secondEnd--;
			}else{
				first[modifiedEnd] = first[firstEnd];
				firstEnd--;
			}
			modifiedEnd--;
		}
		return first;
	}
	
	public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 1;
		a[1]=2;
		a[2]=3;
		
		int[] b= {5,6,7};
		
		for(int val:new MergeTwoSortedArrays().mergeTwoArrays(a, b, 2, 2)){
			System.out.print(val+",");
		}
	}

}
