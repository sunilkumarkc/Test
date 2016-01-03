package com.study.problems;

public class QucikSort {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 2, 5, 4, 6, 3, 7 };
		print(arr);
		arr = quickSort(arr, 0, arr.length - 1);
		print(arr);
	}
	
	static void print (int[] arr){
		for(int i:arr){
			System.out.print(i+",");
		}
		System.out.println("");
	}

	private static int[] quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return arr;
		}
		int pivot = arr[high];
		int partition = partition(arr, low, high, pivot);
		arr = quickSort(arr, low, partition - 1);
		arr = quickSort(arr, partition + 1, high);

		return arr;
	}

	private static int partition(int[] arr, int low, int high, int pivot) {
		int leftCursor = low - 1;
		int rightCursor = high;
		while (leftCursor < rightCursor) {
			while(arr[++leftCursor]<pivot);
			while(rightCursor>0 && arr[--rightCursor]>pivot);
			if(leftCursor < rightCursor){
				swap(arr,leftCursor,rightCursor );
			}else{
				break;
			}
		}
		swap(arr,leftCursor,high);
		print(arr);
		return leftCursor;
	}

	private static void swap(int[] arr, int leftCursor, int rightCursor) {
		int temp =  arr[leftCursor];
		arr[leftCursor] = arr[rightCursor];
		arr[rightCursor] = temp;
	}

}
