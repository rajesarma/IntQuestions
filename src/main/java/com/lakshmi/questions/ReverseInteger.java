package com.lakshmi.questions;

public class ReverseInteger {


//	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-2^31, 2^31 -1]. 
//	For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
	
	public static void main(String[] args) {
		
		System.out.println(reverse(001));

	}
	
	public static int reverse(int x) {
        int rev = reverseNum(x);
        
        if((reverseNum(rev) == x) || (x % 10 == 0)) {
            return rev;
        } else {
            return 0;
        }
    }
    
    static int reverseNum(int x) {
        
        int num = x;
		int rev = 0;
		int n = 0;
		
		if(x < 0) {
			num = -num;
		}
		
		while(num !=0 ) {
			n = num % 10;
			rev = (rev * 10) + n ;
			num = num / 10;
		}
		
		if(x < 0) {
			rev = -rev;
		}
        
		return rev;
        
    }
}
