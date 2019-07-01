package questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EnglishToRoman {

	static Map<Long, Character> romanMap = new HashMap<Long, Character>();

	static {
		romanMap.put(1L, 'I');
		romanMap.put(5L, 'V');
		romanMap.put(10L, 'X');
		romanMap.put(50L, 'L');
		romanMap.put(100L, 'C');
		romanMap.put(500L, 'D');
		romanMap.put(1000L, 'M');
	}

	public static void main(String[] args) {

		long englishValue = 3;
		String roman = "";
		
		int length = String.valueOf(englishValue).length();
		
		Long[] englishValueArr = new Long[length];
		
		int count = 0;
		Long n;
		Long k = 1L;
		while(englishValue > 0) {
			n = englishValue % 10;
			englishValue = englishValue / 10;
			englishValueArr[count] = (n * k);
			count++;
			k = k * 10;
		}
		
		Arrays.sort(englishValueArr, Collections.reverseOrder());
		
		for(int i =0; i<englishValueArr.length; i++) {
			System.out.println(englishValueArr[i]);
			roman = roman + convertToRoman(englishValueArr[i]);
		}
		
		System.out.println(roman);
	}

	static String convertToRoman(long engValue) {

		if (romanMap.containsKey(engValue)) {
			return String.valueOf(romanMap.get(engValue));
		} else {

			Long finalValue = 0L;
			Long previous = 0L;
			Long present = 0L;
			String roman = "";
			boolean processPending = false;
			
			Set<Long> romanSet = new TreeSet<>(Comparator.reverseOrder());

			romanSet.addAll(romanMap.keySet());
			Iterator<Long> iterator = romanSet.iterator();
			
			while (iterator.hasNext()) {
				present = iterator.next();
				
				if(engValue > present) {
				
					if ( (previous - engValue) == (previous / 10) ) {
						finalValue = (previous - engValue);
	
						if (romanMap.get(finalValue) == null) {
							roman = romanMap.get(1L) + "" + romanMap.get(previous);
						} else {
							roman = romanMap.get(finalValue) + "" + romanMap.get(previous);
						}
						break;
						
					} else if ( (previous - engValue) < (previous / 2)) {
	
						if(String.valueOf(engValue).length() == 1) {
							if((engValue > present) && (present > 1) ) {
								finalValue = (engValue - present);
								processPending = true;
							} else {
								roman = romanMap.get(1L) + "" + romanMap.get(previous);
							}
						} else {
							
							if((previous - engValue) == (previous / 10)) {
								finalValue = (previous - engValue);
								roman = romanMap.get(finalValue) + "" + romanMap.get(previous);
								
							} else if((previous - engValue) == present) {
								finalValue = (previous - engValue);
								roman = romanMap.get(finalValue) + "" + romanMap.get(previous);
							} else {
								finalValue = (engValue - present );
								processPending = true;
							}
						}
						
						break;
					} else if ((previous - engValue) > (previous / 10) ) {
						finalValue = (engValue - present);
						processPending = true;
						break;
					}
				}

				previous = present;
			}

			if (processPending) {
				if(String.valueOf(engValue).length() > 1) {
					roman = romanMap.get(present) + getString(finalValue);
				} else {
					for(int i=1; i<= finalValue; i++) {
						roman = roman + romanMap.get(1L);
					}
					roman = romanMap.get(present) + roman;
				}
			}
			return roman;
		}
	}

	static String getString(long engValue) {

		Set<Long> romanSet = new TreeSet<>();
		romanSet.addAll(romanMap.keySet());
		Iterator<Long> iterator = romanSet.iterator();
		String value ="";
		long present;
		Long previous = 0L;
		while (iterator.hasNext()) {
			present = iterator.next();
			if (engValue < present) {
				break;
			}
			previous = present;
		}

		int noOfTimes = Integer.parseInt(String.valueOf(engValue).replace("0",""));

		for(int i=1; i<= noOfTimes; i++) {
			value = value + romanMap.get(previous);
		}

		return value;
	}
}