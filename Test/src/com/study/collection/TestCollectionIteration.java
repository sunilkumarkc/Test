package com.study.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCollectionIteration {
	
	public static void main(String[] args) {
		TestBean testBean = new TestBean();
		List<TestBeanItem> intraCountryList =new ArrayList<TestBeanItem>();
		intraCountryList.add(new TestBeanItem("intra1"));
		intraCountryList.add(new TestBeanItem("intra2"));
		
		List<TestBeanItem> international =new ArrayList<TestBeanItem>();
		international.add(new TestBeanItem("international1"));
		international.add(new TestBeanItem("international2"));
		testBean.setIntraCountryList(intraCountryList);
		testBean.setInternationList(international);
		System.out.println(intraCountryList);
		System.out.println(international);
		 for(TestBeanItem beanItem: intraCountryList){
			 beanItem.setEntry("test"); 
		 }
		System.out.println(intraCountryList);
	}

}



class TestBean {
	private List<TestBeanItem> intraCountryList;
	private List<TestBeanItem> internationList;
	public List<TestBeanItem> getInternationList() {
		return internationList;
	}
	public void setInternationList(List<TestBeanItem> internationList) {
		this.internationList = internationList;
	}
	public List<TestBeanItem> getIntraCountryList() {
		return intraCountryList;
	}
	public void setIntraCountryList(List<TestBeanItem> intraCountryList) {
		this.intraCountryList = intraCountryList;
	}
}

class TestBeanItem{
	private String entry;

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	public TestBeanItem(String str) {
		this.entry = str;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.entry;
	}
}