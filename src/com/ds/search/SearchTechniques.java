package com.ds.search;

public class SearchTechniques {
	static int n;

	static boolean linearSearch(Object[] items, Object key) {
		
		for(Object item : items) {
			if(item == key) {
				return true;
			}
		}
		return false;
	}
	
	/*static boolean recursiveLinearSearch(int n, Object[] items, Object key) {
		
		if( n < 0) {
			return false;
		}
		if(key == items[n] && n < items.length) {
			return true;
		}
		else {
			
			 n = n - 1;
			return recursiveLinearSearch(n, items, key);
		}
	}*/
	
	
	static boolean binarySearch(Object[] items, Object key) {
		int low = 0;
		int mid;
		int high = items.length - 1;
		int c;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			c = ( (Comparable) key).compareTo(items[mid]);
			
			if(c < 0) {
				high = mid - 1;
			} else if(c > 0) {
				low = mid + 1;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
