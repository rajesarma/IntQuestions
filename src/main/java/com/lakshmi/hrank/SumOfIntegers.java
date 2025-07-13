package com.lakshmi.hrank;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumOfIntegers {
	
//	Given an array of integers, find the sum of its elements.

	public static void main(String[] args) {
		int[] arr = {1, 2, 3 ,4 ,10, 11};
		
		Arrays.asList(arr).stream().forEach(System.out :: print);
		
		
		System.out.println(sum(arr));
	}
	
	static int sum(int[] ar) {
		return IntStream.of(ar).sum();
	}
	
	
}
