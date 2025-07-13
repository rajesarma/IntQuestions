package com.lakshmi.generics;

public class Test {

	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2){
        return g1.get().equals(g2.get());
    }
	
}

class GenericsType<T>
{

	public Boolean get(){
		
		return false;
	}
	
}