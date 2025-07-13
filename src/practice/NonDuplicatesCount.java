package practice;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NonDuplicatesCount {

	public static void main(String[] args) {
//		String name = "Lakshmi Rajeswara Rao";
		
		String name = "RajRajes";
		
		// Lambda Expression Way 
		List<Character> list = name.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		Map<Character, Long> map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())) ;
		System.out.println(map);

		
		// Finding Non duplicates
		
		List<Character> dupChars = list.stream().filter(ch -> Collections.frequency(list, ch) > 1).collect(Collectors.toList());
		System.out.println(dupChars);
		
		System.out.println(dupChars.size());
	}
	
}
