package com.lakshmi.set_0;

public class LocalVariableInitInCondition {

	public static void main(String[] args) {
		
		// Case 1: value not initialized 
		/*
		int i = 100; 
        int j; 
  
        if (i > 500) { // Note that the condition is false  
            j = i + 5; 
        }
          
        System.out.println("j :" + j); // Compile Time Error, variable j might not have been initialized
		*/
		
		// Case 2: value initialized
		/*
		int i = 100; 
        int j = 0; 
  
        // Note that the condition is false 
        if (i > 500) { 
            j = i + 5; 
        }
        
        System.out.println("j :" + j); // No error 
		    */     
		
		// Case 3: value initialized and the condition is true
		/*
		int x = 90; 
        int y = 80; 
        int z; 
  
        // The condition is true 
        if (x > y) { 
            z = x + 5; 
        }
         
        System.out.println("z :" + z); // Compile Time Error, variable i might not have been initialized
        */
        // It gives a compilation error irrespective of the condition being true or false because Java didn’t read variables at compile time and thus ‘i’ isn’t initialized. 
		
		
		
		// this doesn’t happen if values are specified instead of variables.
		// Case 3: Value not initialized
		int c = 90; 
		int d; 
        if (90 > 80) { 
            d = c + 5; 
        }
        
        System.out.println("i :" + d); 
	}
	
	// values are read at compile time. 
	// But, variables are read at run-time. 
	// Hence, when variables are a part of the condition, and another variable is initialized inside the conditional block, it gives an unexpected compile-time error
	

}
