package interviews;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberOfCharacters {

	public static void main(String[] args) {

		String name = "Lakshmi Rajeswara Rao";
		
		// Lambda Expression Way 
		List<Character> list = name.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

		Map<Character, Long> map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())) ;
		System.out.println(map);

		// Traditional Way
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		for(char charAt : name.toCharArray()){
			if(!countMap.containsKey(charAt)) {
				countMap.put(charAt, 1);
			} else {
				countMap.put(charAt, countMap.get(charAt) + 1);
			}
		}
		System.out.println(countMap);
		
		// How many times the specified character is repeating
		System.out.println(Collections.frequency(list, 'm'));
		
		// Finding duplicates
		List<Character> nameCharslist = name.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		
		Set<Character> dupChars = nameCharslist.stream().filter(ch -> Collections.frequency(nameCharslist, ch) > 1).collect(Collectors.toSet());
		System.out.println(dupChars);
	}
}
