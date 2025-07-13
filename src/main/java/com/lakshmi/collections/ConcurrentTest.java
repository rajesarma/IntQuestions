package com.lakshmi.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ConcurrentTest {

	public static void main(String[] args) {

		ConcurrentHashMap<String, String> cHashMap = new ConcurrentHashMap<String, String>();
		//cHashMap.put(null, null);
		
		//System.out.println(cHashMap.get(null));
		
		Hashtable<String, String> hTable = new Hashtable<String, String>();
		
		//hTable.put(null, null);
		
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put(null, null);
		hMap.put(null, null);
		hMap.put(null, null);
		hMap.put(null, "Test");
		hMap.put(null, "Test1");
		hMap.put(null, "Test2");
		hMap.put(null, "");
		hMap.put(null, "");
		
		if(hMap.get(null)==null)
			System.out.println("Null value returned");
		else if(hMap.get(null)!=null)
			System.out.println(hMap.get(null));
		
		if(hMap.containsKey(null))
			System.out.println(hMap.get(null));
		
		Map<String, String> map = new HashMap<String, String>();
		
//		
	      
	}
	
	
	
	

}




