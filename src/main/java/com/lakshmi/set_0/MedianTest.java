package com.lakshmi.set_0;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MedianTest {

	public static void main(String[] args) {
		
		
		HashMap<Integer,Integer> keyMap = new HashMap<>();
		
//		Integer[] sampleArray = {2,5,4,3,1,2,4,7,5,8,2,10,6,4,9,1,9,5};
//		List<Integer> list1 = Arrays.asList(sampleArray);
		
		int[] sampleArray = {2,5,4,3,1,2,4,7,5,8,2,10,6,4,9,1,9,5};
		
		List<Integer> list1 = Arrays.stream(sampleArray).boxed().collect(Collectors.toList());
		
		for(Integer key : list1) {
			if(keyMap.containsKey(key) ) {
				keyMap.put(key, keyMap.get(key) + 1);
			}
			else {
				keyMap.put(key, 1);
			}
		}
		
		System.out.println("Actual Order based on keys : "+keyMap);
		
		// Sort based on values
		Map<Integer, Integer> sortedMapDesc = keyMap.entrySet()
											        .stream()
											        .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
											        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println("Sorted Order based on values : "+sortedMapDesc);
		
		Map.Entry<Integer,Integer> entry1 = sortedMapDesc.entrySet().iterator().next();
		
		System.out.println(entry1.getKey());
		
		
		/*
		ArrayList<Integer> medianList = new ArrayList<Integer>();
		HashMap<Integer,Integer> medianMap = new HashMap<>();
			
		for (Map.Entry<Integer, Integer> entry : sortedMapDesc.entrySet()){
			
			if(!medianMap.containsValue(entry.getValue()) ) {
				medianMap.put(entry.getKey(), entry.getValue());
				medianList.add(entry.getKey());
			}
		}
		
		//System.out.println(medianList);
		System.out.println(medianList.get(0));*/
		
	}
	
	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
	
	
}



//List<Integer> list = IntStream.of(sampleArray).sorted().mapToObj(i -> i).collect(Collectors.toList());

//int[] sampleArray = {2,5,4,3,1,2,4,7,5,8,2,10,4,6,4,9,1,9,5};
//List<Integer> list1 = Arrays.stream(sampleArray).boxed().collect(Collectors.toList());