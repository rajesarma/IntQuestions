package com.lakshmi.questions;

public class SubStrings {

	public static void main(String[] args) {

		String str = "Jaava";
		
		for(int i = 0; i<str.length(); i++ ) {
			
			for(int j = i+1; j<str.length(); j++ ) {
				System.out.println(str.substring(i,j));
				
			}
		}

	}

}
