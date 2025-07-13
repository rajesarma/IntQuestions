package com.lakshmi.oca;

public class PassingProgramArguments {

	
	// pass 1 11 Ejava Guru as program arguments
	
	public static void main(String... cmd) {
		
		main("private", cmd);
		
	}
	
	private static void main(String type, String[] args) {
		System.out.println(args[0] + args[1]);
	}
	
	//output 111
}
