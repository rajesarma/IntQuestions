package com.lakshmi.streams;

import java.util.stream.IntStream;

public class HighestSmallest {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5,6,7,8,9};
		
		int minValue = nums[0];
		int maxValue = nums[0];
		for(int i =0; i< nums.length; i++) {
			if(nums[i] < minValue) {
				minValue = nums[i];
			}
			
			if(nums[i] > maxValue) {
				maxValue = nums[i];
			}
		}
		
		System.out.println(minValue +", "+ maxValue);
		
		// Lambda Expression
		System.out.println(IntStream.of(nums).min().getAsInt());
		System.out.println(IntStream.of(nums).max().getAsInt());
		
	}

}
