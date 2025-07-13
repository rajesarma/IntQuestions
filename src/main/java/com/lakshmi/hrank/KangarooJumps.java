package com.lakshmi.hrank;

public class KangarooJumps {

//	The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's starting location (i.e., x2> x1). 
//	Because the second kangaroo moves at a faster rate (meaning v2 > v1) and is already ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO.

//	Sample 0 3 4 2 : x1=0, v1=3, x2=4, v2=3		-> Output : YES	
//	Sample 0 2 5 3 : x1=0, v1=2, x2=5, v2=3		-> Output : NO
	
	public static void main(String[] args) {
		
		System.out.println(kangaroo(0, 3, 4, 2));
		System.out.println(kangaroo(0, 2, 5, 3));
		System.out.println(kangaroo(1, 1, 2, 1));
		System.out.println(kangaroo(5, 3, 0, 2));
		System.out.println(kangaroo(2, -1, 1, 1));
	}
	
	static String kangaroo(int x1, int v1, int x2, int v2) {
        
		String result = "NO";
		
		if(v1 <=0 || v2 <=0 ) {
			return result;
		}
		
		if(((x2 > x1) && (v2 == v1)) || ((x2 > x1) && (v2 > v1)) || ((x1 > x2) && (v1 > v2))) {
            return result;
        }
		
		while(x1 != x2) {		        	
	        	x1 += v1;
	        	x2 += v2;
	        	
	        	if(x1> x2) {
	        		break;
	        	}
	        	
	        	if(x1 == x2) {
	        		System.out.println("Counting Step: "+x1);
	        		result = "YES";
	        		break;
	        	}
		}
		
		return result;
    }
}
