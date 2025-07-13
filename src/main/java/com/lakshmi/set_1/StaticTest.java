package com.lakshmi.set_1;


class MyTest { 
    
	
	
	static
    { 
		System.out.println("Before Inii");
		initialize(); 
		System.out.println("After Inii");
    } 
      
    private static int sum; 
      
    public static int getSum() 
    { 
        initialize(); 
        return sum; 
    } 
  
    //private static boolean initialized1 = true; 
    private static boolean initialized = false; 
    
  
    private static void initialize() 
    { 
       // System.out.println(initialized1);
    	
    	System.out.println("In inint");
        
    	if (!initialized) { 
            for (int i = 0; i < 100; i++) 
                sum += i; 
            initialized = true; 
        } 
    } 
} 
  

public class StaticTest { 
    public static void main(String[] args) 
    { 
        System.out.println(MyTest.getSum()); 
    } 
}


 
