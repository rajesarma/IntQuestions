package com.lakshmi.questions;

import java.lang.reflect.InvocationTargetException;

public class ClassTypeAssigningTest {

	public static void main(String[] args) {

		
		String s = method(String.class);
		s = s + "Testing this";
		System.out.println(s);
		
		Integer i = method(Integer.class);
		i = i + 10;
		System.out.println(i);
		
		/*Integer i1 = new Integer(10);
		Integer i2 = new Integer(20);
		System.out.println(i1.equals(i2));
		
		System.out.println(Integer.max(3, 5));*/
	}
	
	static <T> T method(Class<T> c) {
		
		T t = null;
		try {
			
//			return c.getConstructor(c).newInstance(def);
			if(c.isInstance(new String())) {
				return c.newInstance();
			}
			
			t = c.cast(new Integer(0) );
			return t;
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

}
