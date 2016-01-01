package com.study.problems;

public class BinarySearch {

	public int binarySearch(int[] elements, int low, int high, int element) {

		while (low < high) {
			int mid = (low + high) / 2;
			if (elements[mid] == element) {
				return mid;
			} else if (element < mid) {
				return binarySearch(elements, low, mid - 1, element);
			} else {
				return binarySearch(elements, mid + 1, high, element);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7 };

		System.out.println(new BinarySearch().binarySearch(input, 0,
				input.length, 9));
	}

}
