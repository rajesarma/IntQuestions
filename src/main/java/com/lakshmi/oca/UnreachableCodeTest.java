package com.lakshmi.oca;

public class UnreachableCodeTest {

	// Unreachable Code
	/*public void method1() {
		System.out.println("java");
		return;
		System.out.println("papers");
	    }*/
	
	// Works well
	public static void method2() {
		System.out.println("java");
		if(true) {
		    return;
		}
		System.out.println("papers");
	    }
	
	// Unreachable Code
	/*public void method3() {
		System.out.println("java");
		while(true) {
		    return;
		}
		System.out.println("papers");
	    }*/
	
	
	public static void main(String[] args) {
		System.out.println("Test");
		
		if(true) {
			System.out.println("True");
		}
		
		if(false) {
			System.out.println("Dead Code");
		}
		
	}
	
}

//The word Unreachable is defined in java language specification for every block like if, for, while, etc individually.
//
//The block that is the body of a constructor, method, instance initializer, or static initializer is reachable…
//
//like the above JLS goes on to define unreachable for all blocks including while, for, do, if, switch, etc separately.
//
//The most general logic in these rules are, code surrounded by a block is unreachable 
//if the conditional expression deciding it evaluates to false and then the block is decided as unreachable. 
//Then it becomes an error.
//
//Only for ‘if’ construct the rule is different. The conditional expression is not evaluated and decided. Whatever may be the expression inside the if condition, 
//it is not evaluated to decide if the code block is reachable and so we will not get error even if we have a constant value ‘false’ as conditional expression in if statement. 
//This is treated special to give a facility for the developer. Developers can use a flag variable in the if statement with default final values as false or true. 
//Just by changing the flag variable from false to true or vice-versa developers can recompile the program and use it differently.