package com.lakshmi.questions;

class SuperClass {
	public static void staticMethod(){

		System.out.println("SuperClass: inside staticMethod");

	}
}

class SubClass extends SuperClass{
	
//	@Override // will not accept
	public static void staticMethod(){

		System.out.println("SubClass: inside staticMethod");

	}
}


public class StaticMethodOverride {

	public static void main(String[] args) {
		SuperClass superClassWithSuperCons = new SuperClass();

		SuperClass superClassWithSubCons = new SubClass();

		SubClass subClassWithSubCons = new SubClass();


		superClassWithSuperCons.staticMethod();

		superClassWithSubCons.staticMethod();

		subClassWithSubCons.staticMethod();

	}

}
