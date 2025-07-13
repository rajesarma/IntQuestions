package com.lakshmi.questions;

import java.util.Arrays;

public class AnagramCheck {

	
	// Two Strings are anagrams if they contain same characters but in different order.
	
	public static void main(String[] args) {
		String s1 = "Jaava";
		String s2 = "avaaJ";
		
		System.out.println(anagramCheck(s1, s2));
		
	}
	
	static boolean anagramCheck(String s1, String s2) {
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		
//		System.out.println(chars1);
//		System.out.println(chars2);
		
//		char c  =96;
		
		for(char c=0; c< 127;c++)
		System.out.print(c+ " ");
		
		return Arrays.equals(chars1, chars2);
	}
	
}
