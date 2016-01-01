package com.study.problems;

public class MergeTwoSortedArrays {

	public int[] mergeTwoArrays(int[] first, int[] second, int firstEnd,
			int secondEnd) {
		int modifiedEnd = firstEnd + secondEnd - 1;
		int firstLastIndex = firstEnd - 1;
		int secondLastIndex = secondEnd - 1;
		while (secondLastIndex >= 0) {
			if (firstLastIndex >= 0
					&& first[firstLastIndex] >= second[secondLastIndex]) {
				first[modifiedEnd] = first[firstLastIndex];
				firstLastIndex--;
				
			} else {
				first[modifiedEnd] = second[secondLastIndex];
				secondLastIndex--;
			}
			modifiedEnd--;
		}
		return first;
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 7;
		a[1] = 8;
		a[2] = 9;

		int[] b = { 5, 6, 7 };

		for (int val : new MergeTwoSortedArrays().mergeTwoArrays(a, b, 3, 3)) {
			System.out.print(val + ",");
		}
	}

}
