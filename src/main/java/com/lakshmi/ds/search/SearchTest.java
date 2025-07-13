package com.lakshmi.ds.search;

public class SearchTest {

	static Object[] items = {89, 45, 175, 7, 50, 43, 126, 90};
	static Object key = 126;
	
	static Object[] items1 = {"AP", "KA", "MH", "MP", "OR", "TN", "UP", "WB"};
	static Object key1 = "UP";
	
	public static void main(String[] args) {

		if(SearchTechniques.linearSearch(items, key)) {
			System.out.println("Item Found");
		} else {
			System.out.println("Item not Found");
		}
		
		if(SearchTechniques.binarySearch(items1, key1)) {
			System.out.println("Item Found");
		} else {
			System.out.println("Item not Found");
		}
		
		/*if(SearchTechniques.recursiveLinearSearch(items.length, items, key)) {
			System.out.println("Item Found");
		} else {
			System.out.println("Item not Found");
		}*/
		
		
	}

}
