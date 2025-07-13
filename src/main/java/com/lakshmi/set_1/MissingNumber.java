package com.lakshmi.set_1;

public class MissingNumber {

	// Function to ind missing number 
	static int getMissingNo (int a[], int n){ 
	    int i, total; 
	    total  = (n+1)*(n+2)/2;    
	    
	    for ( i = 0; i< n; i++) { 
	       total -= a[i]; 
	    }
	    
	    return total; 
	} 
   
/* program to test above function */
    public static void main(String args[]) 
    { 
        int a[] = {6,1,2,3,4,5,8,9}; 
//        int miss = getMissingNo(a, a.length);
        
        int i, total, n = a.length; 
	    total  = (n+1)*(n+2)/2;    
	    
	    for ( i = 0; i< n; i++) { 
	       total -= a[i]; 
	    }
        
        System.out.println(total);    
    } 
} 
