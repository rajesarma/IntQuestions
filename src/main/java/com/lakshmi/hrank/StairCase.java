package com.lakshmi.hrank;

public class StairCase {

//	Print as below
//	     #
//	    ##
//	   ###
//	  #### 
	
	public static void main(String[] args) {


//		Below Code Prints
//		####
//		###
//		##
//		#
		for(int i=1; i <= 4; i++) {
			for(int j=4; j >= i; j--) {
				System.out.print("#");
			}
			System.out.println();
		}
		
//		---------------------------
		
		for(int i=4; i >= 1; i--) {
			for(int j=1; j <= 4; j++) {
				
				if(j<i) {
					System.out.print(" ");
					
				} else {
					System.out.print("#");
				}
					
			}
			
			System.out.println();
		}
		
		
	}

}
