package com.lakshmi.interviews.mphasis;

public class BooleanTest {
	
	public void testIfA() {
		if(testIfB("True")) {
			System.out.println("True");
		} else {
			System.out.println("Not True");
		}
	}
	
	public Boolean testIfB(String str) {
		return Boolean.valueOf(str);
	}
	
	
	public static void main(String[] args) {
		BooleanTest b = new BooleanTest();
		b.testIfA();
	}

}
