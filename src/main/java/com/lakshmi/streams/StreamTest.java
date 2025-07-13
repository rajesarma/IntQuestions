package com.lakshmi.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
		
		public static void main(String[] args) {
			List<Integer> intList = new ArrayList<Integer>();
			
			for(int i=1; i<=10; i++)
				intList.add(i);
			
			int sum =0, sum1=0;
			
			sum = intList.stream().mapToInt(i -> i).sum();
			
			Stream<Integer> str = intList.stream().skip(1);
			
			int sum2 = str.mapToInt(i -> i).sum();
			
			//System.out.println( intList.stream().skip(10) );
			
			
			sum1 = intList.stream().filter(i -> i>5).mapToInt(i -> i).sum();
			
			//System.out.println("intList : "+intList.stream() );
			
			System.out.println("sum : "+sum );
			System.out.println("sum1 : "+sum1 );
			
			System.out.println("sum1 : "+sum2 );
			
			intList.stream().forEach(System.out :: println);
			
			intList.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
			
			//intList.stream(). sorted(Comparator.reverseOrder()).forEach() 
			
			Optional<Integer> ans = intList.stream().findAny(); 
			System.out.println( ans.isPresent() ? ans.get() : "No Value" );
			
			List<String> strList = new ArrayList<String>();
			
			strList.add("Test1");
			strList.add("Test2");
			strList.add("Test3");
			strList.add("Test4");
			
			strList.stream().flatMap(s -> Stream.of(s.charAt(3))).forEach(System.out :: println);
			
			
			Optional<String> strOptional = strList.stream().findAny(); 
			System.out.println( strOptional.isPresent() ? strOptional.get() : "No Value" );
			

			
			
		}
	
}
