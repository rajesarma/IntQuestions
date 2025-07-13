package com.lakshmi.interviews.mphasis;

import java.util.Set;
import java.util.TreeSet;

public class WrappedString {
	private String s;
	
	public WrappedString(String s) {
		this.s = s;
	}
	
	
	
	public static void main(String[] args) {
		Set<Object> hs = new TreeSet<Object>();
		WrappedString ws1 = new WrappedString("test");
		WrappedString ws2 = new WrappedString("test");
		String s1 = new String("test");
		String s2 = new String("test");
		hs.add(ws1);
		hs.add(ws2);
//		hs.add(s1);
//		hs.add(s2);
		//System.out.println(s1 == s2 + " "+ s1.equals(s2));
//		System.out.println(s1.hashCode() + " "+ s2.hashCode());
		System.out.println(ws1.hashCode() + " "+ ws2.hashCode());
		
		System.out.println(hs.size());
	}

}
