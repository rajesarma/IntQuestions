package com.lakshmi.ds.sort;

public class BubbleSort {

	// Time Complexity
	// Worst case : O(n^2)
	// Average case : O(n^2)
	void sort(int[] elements) {
		int n = elements.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n-i; j++) {
				if (elements[j-1] > elements[j]) {
					// swap elements
					temp = elements[j - 1];
					elements[j - 1] = elements[j];
					elements[j] = temp;
				}
			}
		}
	}
}


//1-1 =0 >  1st element > 2nd element ->  
//temp = 10
//1st element = 6
//2nd elemtnt = 10


//10, 6, 7, 4, 5, 2, 1, 8, 3
//6, 10, 7, 4, 5, 2, 1, 8, 3
//6, 7, 10, 4, 5, 2, 1, 8, 3
//6, 7, 4, 10, 5, 2, 1, 8, 3
//6, 7, 4, 5, 10, 2, 1, 8, 3
//6, 7, 4, 5, 2, 10, 1, 8, 3
//6, 7, 4, 5, 2, 1, 10, 8, 3
//6, 7, 4, 5, 2, 1, 8, 10, 3
//6, 7, 4, 5, 2, 1, 8, 3, 10

//6, 4, 7, 5, 2, 1, 8, 3, 10
//6, 4, 5, 7, 2, 1, 8, 3, 10
//6, 4, 5, 2, 7, 1, 8, 3, 10
//6, 4, 5, 2, 1, 7, 8, 3, 10

//4, 6, 5, 2, 1, 7, 8, 3, 10
//4, 5, 6, 2, 1, 7, 8, 3, 10