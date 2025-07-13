package com.lakshmi.sample;

import java.util.Scanner;

public class EofTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count = 1;
		while (sc.hasNext() ) {
			
			System.out.println((count++) + " " + sc.nextLine());
		}
		
	}
	
	
}
