package com.lakshmi.oca;

public class ProtectedMainMethodTest {
	
	protected static void main() {
		System.out.println("Spring");
	}
	
	public static void main(String... args) {
		
		main();
		System.out.println("Summer");
		
		
	}
}
