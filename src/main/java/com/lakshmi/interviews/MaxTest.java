package com.lakshmi.interviews;

import java.util.HashMap;

public class MaxTest {

	public static int maxSubArrayLen(int[] nums, int k) {
	    HashMap<Integer, Integer> map = new HashMap<>();
	    map.put(0, -1);
	    int result = 0;
	    int sum = 0;
	 
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	        if(map.containsKey(sum - k)){
	            result = Math.max(result, i - map.get(sum - k));
	        }
	        map.putIfAbsent(sum, i);
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		
		System.out.println(maxSubArrayLen(nums, k));

	}

}
