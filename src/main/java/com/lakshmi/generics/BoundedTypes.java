package com.lakshmi.generics;


//When a bound includes an interface type, only type arguments that implement that interface are legal. 
//When specifying a bound that has a class and an interface, or multiple interfaces, use the & operator to connect them.

//ex. class Gen<T extends MyClass & MyInterface>

class Stats<T extends Number>{
	// Uses Number class as a Bound
	// The passing Types should be subclass of Number Class
	//A bound can include both a class type and one or more interfaces. In this case, the class type must be specified first.
	
	T[] nums;
	
	Stats(T[] nums){
		this.nums = nums;
	}

	double average() {
		
		double sum=0.0;
		
		for(int i=0;i< nums.length; i++) {
			sum += nums[i].doubleValue();
		}
		
		return sum / nums.length;
	}
}

public class BoundedTypes {

	public static void main(String[] args) {
		
		Integer[] intArray = {3, 5, 7, 2, 9};
		
		Stats<Integer> intOb = new Stats<Integer>(intArray);
		
		System.out.println(intOb.average());
		
//		Not Possible
//		String[] str = {"raj", "sarma"}; 
//		Stats<String> stArr = new Stats<String>(str);
		
	}
}
