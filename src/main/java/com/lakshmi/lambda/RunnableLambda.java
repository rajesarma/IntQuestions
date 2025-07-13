package com.lakshmi.lambda;

public class RunnableLambda {

	
	public static void main(String[] args) {
		
		Thread t = new Thread( () -> System.out.println("Thread") );
		t.run();
	}
	
}


