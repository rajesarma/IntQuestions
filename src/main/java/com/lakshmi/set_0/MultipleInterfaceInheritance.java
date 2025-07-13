package com.lakshmi.set_0;

interface a {
	default void show() {
		System.out.println("In a interface default method");
	}
	
//	int display(); // Method Name Ambiguity with interface b
}

interface b {
	default void show() {
		System.out.println("In b interface default method");
	}
	
	// void display(); // Method Name Ambiguity with interface a
}


public class MultipleInterfaceInheritance implements a, b {

	public static void main(String[] args) {
		
		new MultipleInterfaceInheritance();
		
	}

	//@Override
	public void show() {
		
		a.super.show();
		b.super.show();
	}

	/*@Override
	public void display() {
		
		return;
	}*/
	
	
	// If we have same method name but different return types in two interfaces, We will get Compilation error. So, we cannot implement these two interfaces in the implementation class.
}
