package com.lakshmi.sample;

class AA{
	static{
		System.out.println("A class Static");
	}
	
	AA(){
		
		System.out.println("A class Constructor");
	}
}

class BB extends AA {
	static{
		System.out.println("B class Static");
	}
	
	BB(){
		System.out.println("B class Constructor");
	}
}

public class TestClass {

	public static void main(String[] args) {
		
		BB b = new BB();
	}
}
