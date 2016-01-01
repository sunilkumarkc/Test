package com.study;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtractStartDate {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("E:/Pricing Request Ids with start date.txt");
		Scanner scanner = new Scanner(file);
		Map<String , String> map = new HashMap<String, String>();
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			String[] split = str.split("\\s+");
			map.put(split[0], split[1]);
		}
		
		File file1 = new File("E:/Pricing Request Ids.txt");
		Scanner scanner1 = new Scanner(file1);
		while(scanner1.hasNext()){
			String str = scanner1.nextLine();
			System.out.println(map.get(str.trim()));
		}
	}

}
