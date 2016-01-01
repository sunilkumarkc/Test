/**
 * Apr 8, 2015
 * 924699
 */
package com.study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author 924699
 * 
 */
public class StatLogParser {
	private static String folderName = "C:\\Users\\924699\\Documents\\12-16-15\\L3";
	private static int methodThreshold = 300;

	public static void main(String[] args)  {
		
		File dir = new File(folderName);

		Map<String, List<Integer>> methods = new HashMap<String, List<Integer>>(1000);
		Map<String, List<Integer>> methodsWithThreshold = new HashMap<String, List<Integer>>();
		if (dir.isDirectory()) {
			try {
				parseFile(methods, dir,methodsWithThreshold);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map<String, List<Integer>> sortedMethods = new TreeMap<String, List<Integer>>(new SizeComparator());
			for (String key : methods.keySet()) {
				List<Integer> values = methods.get(key);
				if (values != null) {
					int size = sortedMethods.size();
					sortedMethods.put(key + " : " + values.size()+" - "+methodsWithThreshold.get(key).size(), values);
				
				}
			}
			Set<String> keySet = new TreeSet<String>(new NameAndSizeComparator());
			keySet.addAll(sortedMethods.keySet());
			Map<String, List<Integer>> sortedMethodsWithoutComparator =  new HashMap<String, List<Integer>>(sortedMethods);
			

			for (String key : keySet) {
				//List<Integer> values = sortedMethodsWithoutComparator.get(key);
				//Collections.sort(values);
				//Collections.reverse(values);
				/// if (values.size() > 1 && values.get(0)>1000) {
				//System.out.println(key + " - " + values);
				//System.out.println(key + " - "+new TreeSet(values));
				//System.out.println(key + " - "+new TreeSet(methodsWithThreshold.get(key.substring(0,key.indexOf(":")-1))));
				//if(Integer.valueOf(key.substring(key.lastIndexOf("-")+2, key.length()))>-1){
				System.out.println(key );
				//}
				// }

			}
//			TreeSet<String> exceedingThresholdSet = new TreeSet<String>(new ExceedingThresholdComparator());
//			exceedingThresholdSet.addAll(keySet);
//			for (String key : exceedingThresholdSet) {
//				System.out.println(key );
//			}
			
			
		}
	}

	private static void parseFile(Map<String, List<Integer>> methods, File dir, Map<String, List<Integer>> methodsWithThreshold) throws IOException {
		BufferedReader reader = null;
		List<Integer> responseTimes = null;
		List<Integer> responseTimesWithThreshold = null;
		try {
			for (File file : dir.listFiles()) {
				if (!file.isDirectory()) {
					reader = new BufferedReader(new FileReader(file));
					String fileName = file.getName();
					fileName = fileName.substring(0, fileName.indexOf("-stats"));
					String line = null;
					while ((line = reader.readLine()) != null) {
						String methodName = null;
						try {
							methodName = line.substring(line.indexOf("STATS -") + 7, line.indexOf("method"));
							methodName = fileName + "." + methodName;
							responseTimes = methods.get(methodName);
							responseTimesWithThreshold = methodsWithThreshold.get(methodName);
							if (responseTimes == null) {
								responseTimes = new ArrayList<Integer>();
							}
							if (responseTimesWithThreshold == null) {
								responseTimesWithThreshold = new ArrayList<Integer>();
							}

							Integer responseTime = Integer.valueOf((line.substring(line.indexOf("time:") + 5, line.indexOf(" ms")).trim()));
							if (responseTime > methodThreshold) {
								responseTimesWithThreshold.add(responseTime );
//								if(methodName.equalsIgnoreCase("eprs-workflow-service. getPricingTasks ")){
//									System.out.println(responseTime+"  -  "+line.substring(0,line.indexOf(" INFO")));
//								}
							}
							if (responseTime > 0) {
								responseTimes.add(responseTime);
							}
						

							methods.put(methodName, responseTimes);
							methodsWithThreshold.put(methodName, responseTimesWithThreshold);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					parseFile(methods, file,methodsWithThreshold);
				}

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if(reader != null){
				reader.close();
			}
		}
	}

}

class SizeComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if (o1 != null && o2 != null) {
			int compare=Integer.valueOf(o2.substring(o2.indexOf(": ") + 2,o2.indexOf(" -"))).compareTo(Integer.valueOf(o1.substring(o1.indexOf(": ") + 2,o1.indexOf(" -"))));
			if(compare==0){
				compare=1;
			}
			return compare;
		}
		return 0;
	}

}

class NameAndSizeComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1 != null && o2 != null) {
			if (o1.substring(0, o1.indexOf(".")).compareTo(o2.substring(0, o2.indexOf("."))) == 0) {
				int size = Integer.valueOf(o2.substring(o2.indexOf(": ") + 2,o2.indexOf(" -"))).compareTo(Integer.valueOf(o1.substring(o1.indexOf(": ") + 2,o1.indexOf(" -"))));
				if(size==0){
					size =1;
				}
				return size;
			} else {
				return o1.substring(0, o1.indexOf(".")).compareTo(o2.substring(0, o2.indexOf(".")));
			}
		}
		return 0;
	}

}


class ExceedingThresholdComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1 != null && o2 != null) {
			Double thresholdExceed1 = Double.valueOf(o1.substring(o1.indexOf("- ") + 2,o1.length()));
			Double thresholdExceed2 = Double.valueOf(o2.substring(o2.indexOf("- ") + 2,o2.length()));
//			thresholdExceed1 = thresholdExceed1==0?1:thresholdExceed1;
//			thresholdExceed2 = thresholdExceed2==0?1:thresholdExceed2;
			if(thresholdExceed1>10 && thresholdExceed2>10){
				Double variance1 = thresholdExceed1/(Double.valueOf(o1.substring(o1.indexOf(": ") + 2,o1.indexOf(" -"))));
				Double variance2 = thresholdExceed2/(Double.valueOf(o2.substring(o2.indexOf(": ") + 2,o2.indexOf(" -"))));
				return variance2.compareTo(variance1);
				
			}
			
		}
		return 0;
	}

}
