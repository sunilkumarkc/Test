package com.study.problems;

public class FindElementInCircularSortedArray {

	public int binarySearch(int[] elements, int low, int high, int element) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (elements[mid] == element) {
				return mid;
			} else if (element > elements[mid] && element <= elements[high - 1]) {
				return binarySearch(elements, mid + 1, high, element);
			} else {
				return binarySearch(elements, low, mid - 1, element);
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] input = { 7, 8, 1, 2, 3, 4, 5, 6 };
		System.out.println(new FindElementInCircularSortedArray().binarySearch(
				input, 0, input.length, 7));
	}

}
