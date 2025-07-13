package com.lakshmi.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Emp{
	private String name;
	Emp(final String name) {
		this.name = name;
	}
}

public class SetTest {

	public static void main(String[] args) {
		TreeSet<Emp> s = new TreeSet<>();
		
//		s.add("test");
//		s.add("test");
		
		s.add(new Emp("Raj"));
		s.add(new Emp("Raj"));
		
		System.out.println(s);
		
		Map<Object, Integer> test = new HashMap<>();

	}

}
