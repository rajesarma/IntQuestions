package com.lakshmi.set_1;

public class StaticBlocksAndVariables {

	public static void main(String[] args) {
		new StaticBlocksAndVariables();
		//System.out.println(flag);

	}
	
	static boolean flag=true;
	static int i=20;
	
	static {
		System.out.println("In static block");
		
		System.out.println(StaticBlocksAndVariables.flag);
		System.out.println(StaticBlocksAndVariables.i);
	}
	
	
	
}
