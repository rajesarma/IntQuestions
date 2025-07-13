package practice;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.collections.map.MultiValueMap;

public class MultiValueTest {

	public static void main(String[] args) {
		
		MultiMap valueMap = new MultiValueMap();
		
		valueMap.put("a", "First");
		valueMap.put("a", "Second");
		
		List<String> list = (List<String>)valueMap.get("a");
		
		for(String s : list) {
			System.out.println(s);
		}
		
//		MultiKeyMap keyMap = new MultiKeyMap();
		
		MultiMap hMap = new MultiHashMap();
		hMap.put("1", "First");
		hMap.put("1", "Second");
		hMap.put("1", "Third");
		
		Collection coll = (Collection)hMap.get("1");
		
		for(Object s : coll) {
			System.out.println(s);
		}
		
	}

}
