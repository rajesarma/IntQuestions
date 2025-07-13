package com.lakshmi.hrank;

public class PosNegZeroCountFraction {
	
//	Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros. Print the decimal value of each fraction on a new line.
//	 It should print out the ratio of positive, negative and zero items in the array, each on a separate line rounded to six decimals.

	public static void main(String[] args) {
		int[] arr = {-4, 3, -9, 0, 4, 1}; 
		
		plusMinus(arr);
		
		
	}
	
	
	static void plusMinus(int[] arr) {
		double posCount =0, negCount=0, zeroCount=0;
		
		for(int index =0; index< arr.length; index++) {
			if(arr[index] > 0) {
				posCount++;
			} else if(arr[index] < 0) {
				negCount++;
			} else {
				zeroCount ++;
			}
		}
		
		System.out.println(String.format("%.6f", (posCount/arr.length)));
		System.out.println(String.format("%.6f", (negCount/arr.length)));
		System.out.println(String.format("%.6f", (zeroCount/arr.length)));
	}

}


/**/