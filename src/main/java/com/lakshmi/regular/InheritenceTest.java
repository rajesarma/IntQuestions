package com.lakshmi.regular;

class supclass{
	public static final String testData="data";
	
	public static void  testMethod()
	{
		System.out.println("testMethod::supclass");
	}
	
	
	
}

class subclass  extends supclass{
	
	public void testData()
	{
		System.out.println(testData);
		
	}
	public static void testMethod()
	{
		System.out.println("testMethod:subclass");
	}
} 

public class InheritenceTest {

	public static void main(String[] args) {
		supclass sup = new subclass();
		sup.testMethod();
	}
}
