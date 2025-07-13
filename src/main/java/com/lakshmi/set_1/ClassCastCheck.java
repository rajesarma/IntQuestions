package com.lakshmi.set_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassCastCheck {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Sarma");
		m1();
	}
	
	static void m1(){
		List<Date> list = new ArrayList<Date>();
		
		m2(list);
	}
	
	static void m2(Object arg){
		List<String> list = (List<String>)arg;
		
		m3(list);
	}
	
	static void m3(List<String> list){
		String s = list.get(0);
		System.out.println(s);
	}

}
