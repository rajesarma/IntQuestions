package com.lakshmi.set_0;

public class Unreacheable {

	public static void main(String[] args) {
		
		// case 1 : non final variables
		int c = 14, d = 16; // initialisation of variable 
			
		while (c < d) { 
			System.out.println("Hello i am in infinite loop");  
	    } 
	  
	    // last print statement, in this case it is not unreachable 
		System.out.println("Unreachable statement");
		
		
		// case 2 : final variables 
		final int a = 14, b = 16; // initialisation of variable 
		
		 while (a < b) { 
			 System.out.println("Hello i am in infinite loop");  
	     } 
	  
	        // last print statement, in this case unreachable 
//		 System.out.println("Unreachable statement");
		 
	}

	// In case 1 : since the variables c, d are declared as non final. 
	// So, the value of these variables can be changed in the program. 
	// JVM thinks that at any point of time there is a chance that the change the value of a and b, and the last statement may be executed, so no error.
	
	// In case 2 : since the variables a, b are declared as final. 
	// So, the value of these variables can not be changed throughout the life cycle of the program no condition will be approached to come out of the while loop. 
	// This in turn makes the second statement unreachable i.e. jvm can�t reach to that statement during program life cycle
	
	
}
