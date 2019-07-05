package questions;

public class SumTwoNumbersEqualsTarget {
	
	// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	// You may assume that each input would have exactly one solution, and you may not use the same element twice.

	public static void main(String[] args) {
		
		int[] nums = {2,7,11,15};
		
		int[] output = twoSum(nums, 22);
		
		for(int i=0; i< output.length; i++) {
			System.out.println(output[i]);
		}
		
	}
	
	
	public static int[] twoSum(int[] nums, int target) {
        
        int[] output = new int[2];
        for(int i=0; i< nums.length; i++) {
            
            for(int j=i+1; j< nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        
        return output;
    }

}
