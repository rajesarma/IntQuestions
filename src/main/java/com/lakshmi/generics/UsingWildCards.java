package com.lakshmi.generics;


//The wildcard argument is specified by the ?, and it represents an unknown type
//It is important to understand that the wildcard does not affect what type of Stats objects can be created. 
//This is governed by the extends clause in the Statistics declaration.
//The wildcard simply matches any valid Statistics object.

class Statistics<T extends Number>{
	// Uses Number class as a Bound
	// The passing Types should be subclass of Number Class
	//A bound can include both a class type and one or more interfaces. In this case, the class type must be specified first.
	
	T[] nums;
	
	Statistics(T[] nums){
		this.nums = nums;
	}

	double average() {
		
		double sum=0.0;
		
		for(int i=0;i< nums.length; i++) {
			sum += nums[i].doubleValue();
		}
		
		return sum / nums.length;
	}
	
	boolean isSameAverage(Statistics<?> obj) {
		
		if(average() == obj.average()) {
			return true;
		}
		else
			return false;
	}
}

public class UsingWildCards {

	public static void main(String[] args) {
		
		Integer[] intArray = {3, 5, 7, 2, 9};
		
		Statistics<Integer> intOb = new Statistics<Integer>(intArray);
		
		System.out.println(intOb.average());
		
		Double[] dobArray = {3.0, 5.0, 7.0, 2.0, 9.0};
		
		Statistics<Double> dobOb = new Statistics<Double>(dobArray);

		System.out.println(dobOb.average());
		
		System.out.println(intOb.isSameAverage(dobOb));
		
	}
}
