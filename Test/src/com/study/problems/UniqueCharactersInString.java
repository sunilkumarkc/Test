package com.study.problems;

public class UniqueCharactersInString {

	public boolean checkUnique(String input) {
		if (input == null) {
			return false;
		}
		boolean result = true;
		boolean[] characters = new boolean[128];
		for (int i = 0; i < input.length(); i++) {
			int character = input.charAt(i);
			if (characters[character] == false) {
				characters[character] = true;
			} else {
				result = false;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		UniqueCharactersInString uniqueCharactersInString = new UniqueCharactersInString();
		System.out.println(uniqueCharactersInString.checkUnique(null));
		System.out.println(uniqueCharactersInString.checkUnique("Hello"));
		System.out.println(uniqueCharactersInString.checkUnique("Unique"));
		System.out.println(uniqueCharactersInString.checkUnique("HelLo"));
	}

}
