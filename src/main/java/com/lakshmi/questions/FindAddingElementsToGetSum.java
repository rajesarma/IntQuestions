package com.lakshmi.questions;

public class FindAddingElementsToGetSum {

	public static void main(String[] args) {

		int[] arr = {1,2,2,1,3};
		
		int[] sol = twoSum(arr, 4, 2);
		
		for(int i=0; i<sol.length; i++) {
			System.out.print(sol[i]+" ");
		}
	}
	
	static int[] twoSum(int[] nums, int target, int noOfElements) {
	       
        int[] a = new int[noOfElements];
        
        boolean notFound = true;
        
        for(int i=0;i<nums.length-1 ;i++){
            for(int j=i+1;j<nums.length ;j++){
            	
                if((nums[i]+nums[j]) == target && notFound){
                    a[0]=i;
                    a[1]=j;
                    notFound = false;
                    break;
                }
            }
       
           
    }
        return a;
    }

}

