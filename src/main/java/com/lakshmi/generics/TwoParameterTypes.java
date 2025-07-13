package com.lakshmi.generics;

class TwoGen<T, V>{
	
	T ob1;
	V ob2;
	
	TwoGen(T ob1, V ob2){
		this.ob1 = ob1;
		this.ob2 = ob2;
	}

	public T getOb1() {
		return ob1;
	}

	public V getOb2() {
		return ob2;
	}

	void showTypes(){
		System.out.println("The first type is : "+ ob1.getClass().getTypeName() + 
				", The second type is : "+ ob2.getClass().getTypeName());
		
	}
}

public class TwoParameterTypes {

	public static void main(String[] args) {
		
		TwoGen<Integer, Integer> intOb = new TwoGen<Integer, Integer>(36, 34);
		
		intOb.showTypes();
		
		System.out.println("First Type Value is "+intOb.getOb1());
		System.out.println("Second Type Value is "+intOb.getOb2());
		
		TwoGen<String, Integer> strIntOb = new TwoGen<String, Integer>("Sarma", 34);
		
		strIntOb.showTypes();
		
		System.out.println("First Type Value is "+strIntOb.getOb1());
		System.out.println("Second Type Value is "+strIntOb.getOb2());
		
	}
	
}
