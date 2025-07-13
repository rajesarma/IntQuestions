package com.lakshmi.generics;


//The wildcard argument is specified by the ?, and it represents an unknown type
//It is important to understand that the wildcard does not affect what type of Stats objects can be created. 
//This is governed by the extends clause in the Statistics declaration.
//The wildcard simply matches any valid Statistics object.

//A bounded wildcard specifies either an upper bound or a lower bound for the type argument. 
//This enables you to restrict the types of objects upon which a method will operate. 
//The most common bounded wildcard is the upper bound, which is created using
//an extends clause in much the same way it is used to create a bounded type.

//<? super subclass>
//We can use super keyword for bounded types.
//In this case only classes that are superclasses of subclass are acceptable arguments. 
//This is an inclusive clause.

class OneD{
	
	int x;
	OneD(){
		
	}
	
	OneD(int x) {
		this.x = x;
	}
}

class TwoD extends OneD{
	
	int x,y;
	public TwoD(int a, int b) {
		super(a);
		x=a; y=b; 
	}
}

class ThreeD extends TwoD{
	int z;
	public ThreeD(int a, int b, int c) {
		super(a, b);
		z=c;
	}
}

class FourD extends ThreeD{
	int time;
	public FourD(int a, int b, int c, int d) { 
		super(a, b, c);
		time = c;
	}
}

class Coords<T extends TwoD>{
	T[] coords;
	
	Coords(T[] objs) { coords = objs; }
}

public class BoundedWildCards {

	static void showXY(Coords<?> c) {
		System.out.println("X, Y Coordinates");
		
		for(int i=0; i < c.coords.length; i++) {
			System.out.println( "X : "+c.coords[i].x+
								", Y : "+c.coords[i].y);
		}
	}
	
	static void showXYZ(Coords<? extends ThreeD> c) {
		System.out.println("X, Y, Z Coordinates");
		
		for(int i=0; i < c.coords.length; i++) {
			System.out.println( "X : "+c.coords[i].x+
								", Y : "+c.coords[i].y+
								", Z : "+c.coords[i].z);
		}
	}
	
	static void showAll(Coords<? extends FourD> c) {
		System.out.println("X, Y, Z, time Coordinates");
		
		for(int i=0; i < c.coords.length; i++) {
			System.out.println( "X : "+c.coords[i].x+
								", Y : "+c.coords[i].y+
								", Z : "+c.coords[i].z+
								", Time : "+c.coords[i].time);
		}
	}
	
	public static void main(String[] args) {
		
		TwoD[] _2d = {new TwoD(10, 20), new TwoD(20, 30) };
		
		Coords<TwoD> twoD = new Coords<TwoD>(_2d);
		showXY(twoD);
		
		ThreeD[] _3d = {new ThreeD(10, 20, 30), new ThreeD(20, 30, 40) };
		
		Coords<ThreeD> threeD = new Coords<ThreeD>(_3d);
		showXYZ(threeD);
		
		
	}
}
