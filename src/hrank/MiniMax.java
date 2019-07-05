package hrank;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {
	
//	From an integer array
//	Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers
//	Our initial numbers are , , , , and . We can calculate the following sums using four of the five integers:

//	Sample Input: 1 2 3 4 5		Output: 10 14
	
//	If we sum everything except 1, our sum is 2+3+4+5 = 14
//	If we sum everything except 2, our sum is 1+3+4+5 = 13
//	If we sum everything except 3, our sum is 1+2+4+5 = 12
//	If we sum everything except 4, our sum is 1+2+3+5 = 11
//	If we sum everything except 5, our sum is 1+2+3+4 = 10
//	Hints: Beware of integer overflow! Use 64-bit Integer.

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr1 = {7, 69, 2, 221, 8974};
		
		miniMax(arr1);
		
	}

	static void miniMax(int[] arr) {
		
		List<Long> sumList = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		
		for(int i =0; i< arr.length; i ++) {
			tempList = new ArrayList<>();
				
			for(int j =0; j< arr.length; j++) {
				if(i != j) {
					tempList.add(arr[j]);
				}
			}
			
			sumList.add(tempList.stream().mapToLong(v -> v).sum());	// Here we need to convert to long we may get overflow number while adding large integer numbers
		}
		
		System.out.println(sumList.stream().mapToLong(Long :: longValue).min().getAsLong() +" "+ sumList.stream().mapToLong(Long :: longValue).max().getAsLong());
//		System.out.println(sumList.stream().collect(Collectors.summarizingInt(Integer :: intValue)).getMax()+ " "+ sumList.stream().collect(Collectors.summarizingInt(Integer :: intValue)).getMin());
		
	}
	
}
