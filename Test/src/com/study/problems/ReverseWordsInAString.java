package com.study.problems;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		String input = " This is , my car.i love it";
		System.out.println(reverseWords(input));

	}

	private static String reverseWords(String input) {
		if (input == null || input.trim().equals("")) {
			return input;
		}
		int counter = 0;
		int wordStart = 0;
		char[] inputArr = input.toCharArray();
		reverse(inputArr, 0, inputArr.length - 1);
		System.out.println(inputArr);
		while (counter < inputArr.length) {

			if (inputArr[counter] == ' ' || inputArr[counter] == ','
					|| inputArr[counter] == '.') {
				reverse(inputArr, wordStart, counter - 1);
				wordStart = counter + 1;
			}
			counter++;
		}
		reverse(inputArr, wordStart, counter - 1);
		return new String(inputArr);
	}

	private static void reverse(char[] input, int wordStart, int length) {
		char temp = ' ';
		int i = length;
		if (wordStart < i) {
			while (wordStart < i) {
				temp = input[i];
				input[i] = input[wordStart];
				input[wordStart] = temp;
				wordStart++;
				i--;
			}
		}
	}

}
