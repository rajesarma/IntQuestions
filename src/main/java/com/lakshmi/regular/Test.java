package com.lakshmi.regular;

import java.io.Serializable;

 class A1 implements Serializable
{
	int i =10;
	public String getInt()
	{
		return "hello";
	}
}

public class Test {

	public static void main1(String[] args) {
		Class classa = A.class;
		try {
		   A a = (A)classa.newInstance();
//		   System.out.println("Data in "+ a.i);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main2(String[] args) {
		A1 a =new  A1();
		Class cls =a.getClass();
		try {
			A b = (A)cls.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Class cls =Class.forName("A");
			A a =(A)cls.newInstance();
//			System.out.println("Value is"+a.i);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
