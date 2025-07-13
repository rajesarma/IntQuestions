package com.lakshmi.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemovingDuplicateElementsInTwoArrays {

	public static void main(String[] args) {
		String[] s1 = {"abc", "def", "ghi"};
	 	String[] s2 = {"def", "ghi", "jkl"};
	 	
	 	ArrayList s11 = new ArrayList(Arrays.asList(s1));
	 	ArrayList s12 = new ArrayList(Arrays.asList(s2));
	 	
	 	s11.addAll(s12);
	 	
	 	Set set1 = new TreeSet(s11);
	 	
	 	System.out.println(set1);
	}

}
