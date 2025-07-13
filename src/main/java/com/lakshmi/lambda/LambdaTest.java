package com.lakshmi.lambda;

public class LambdaTest {

	public void greet(myLambda lambda) {
		lambda.perform(); 
		
	}
	
	
	public static void main(String[] args) {
		
		myLambda myLambda = () -> System.out.println("Testing ");
		
		addFunction addFunction = (int a, int b) -> a+b; 
		myLambda.perform();
		
		stringLengthLambda strlen = (s) -> s.length();
		
		System.out.println( "String Length : "+ strlen.strlen("Test Class1"));
		
		/*stringLengthLambda strlen1 = s -> s.length();
		
		System.out.println( "String Length : "+ strlen1.strlen("Testing Class"));*/
		
		printLamba(s ->s.length());
		
	}
	
	public static void printLamba(stringLengthLambda l) {
		//System.out.println("Length : "+ l.strlen("Testing Classsses"));
		
		System.out.println( "String Length : "+ l.strlen("Testing Class"));
		
	}
	
}

@FunctionalInterface
interface myLambda{
	void perform(); 
	//void myLabdaFunc1(int a);
	
}

interface addFunction{
	int add(int a, int b); 
	//void myLabdaFunc1(int a); 
}

interface stringLengthLambda{
	int strlen(String s);
	
}