package com.lakshmi.interviews.mphasis.dbs;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		
        //Scanner
        Scanner s = new Scanner(System.in);
        int  testCases = s.nextInt();                 // Reading input from STDIN
       
        for(int i =0; i< testCases; i++) {
        	int  x = s.nextInt();                 // Reading input from STDIN
        	
        	for(int j =1;j<=x; j++ ) {
        		if(j % 3 == 0 && j % 5 == 0) {
        			System.out.println("FizzBuzz");
        		} else  if(j % 3 == 0) {
        			System.out.println("Fizz");
        		} else  if(j % 5 == 0) {
        			System.out.println("Buzz");
        		} else {
        			System.out.println(j);
        		}
        	}
        	
        	
        }
        
        

        
        
        

	}

}
