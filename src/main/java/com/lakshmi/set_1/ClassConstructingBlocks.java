package com.lakshmi.set_1;

public class ClassConstructingBlocks {

	{
		System.out.println("In Instance Initializing Block");
	}
	
	static {
		System.out.println("In Static Block");
	}
	
	ClassConstructingBlocks() {
		System.out.println("In Constructor Block");
	}
	
	// Instance Block
	{
		System.out.println("In Instance Block");
	}
	
	ClassConstructingBlocks(int a) {
		System.out.println("In Parameter Block: "+ a);
		// ClassConstructingBlocks.int_variable = 10;
	}
	
	static int int_variable;
	
	static void test() {
		System.out.println("int_variable : "+ int_variable);
	}
	
	public static void main(String[] args) {
		new ClassConstructingBlocks();
		
		// new ClassConstructingBlocks().test();
		
		System.out.println("--------------------------");
		
		new ClassConstructingBlocks(10);
		//new ClassConstructingBlocks(10).test();
		
	}

}
